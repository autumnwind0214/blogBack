package com.autumn.blog.service.impl;

import com.autumn.blog.common.exception.AutumnException;
import com.autumn.blog.common.result.ResultCodeEnum;
import com.autumn.blog.common.util.AuthContextHolder;
import com.autumn.blog.common.util.BeanCopyUtils;
import com.autumn.blog.common.util.TreeUtils;
import com.autumn.blog.mapper.MenuMapper;
import com.autumn.blog.mapper.UserRoleMapper;
import com.autumn.blog.model.enums.FlagEnum;
import com.autumn.blog.model.enums.MenuType;
import com.autumn.blog.model.dto.MenuDto;
import com.autumn.blog.model.dto.SelectIdsDto;
import com.autumn.blog.model.po.system.Menu;
import com.autumn.blog.model.vo.MenuTreeVo;
import com.autumn.blog.model.vo.MenuVo;
import com.autumn.blog.model.vo.SysMenuVo;
import com.autumn.blog.service.MenuService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<SysMenuVo> queryMenuByUserId(Long userId) {
        List<SysMenuVo> treeList = new ArrayList<>();
        // 查询用户具有的menu_id
        List<String> menuIds = userRoleMapper.queryMenuIdByUserId(userId);
        if (!CollectionUtils.isEmpty(menuIds)) {
            // 菜单全部数据(当前用户下的)
            LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.in(Menu::getId, menuIds).ne(Menu::getMenuType, MenuType.BUTTON.getCode()).orderByAsc(Menu::getDeep).orderByAsc(Menu::getSort);
            List<Menu> list = menuMapper.selectList(queryWrapper);

            // 构建树形
            for (SysMenuVo rootNode : getRootNodes(list)) {
                SysMenuVo menuVo = new SysMenuVo();
                BeanUtils.copyProperties(rootNode, menuVo);
                SysMenuVo.Meta meta = new SysMenuVo.Meta();
                BeanUtils.copyProperties(rootNode, meta);
                menuVo.setMeta(meta);
                SysMenuVo childrenNode = getChildrenNode(menuVo, list);
                treeList.add(childrenNode);
            }
        }

        return treeList;
    }

    @Override
    public List<SysMenuVo> getMenuList() {
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Menu::getSort);

        // 菜单全部数据
        List<Menu> list = list(queryWrapper);
        List<SysMenuVo> treeList = new ArrayList<>();
        // 构建树形
        for (SysMenuVo rootNode : getRootNodes(list)) {
            SysMenuVo menuVo = new SysMenuVo();
            BeanUtils.copyProperties(rootNode, menuVo);
            SysMenuVo.Meta meta = new SysMenuVo.Meta();
            BeanUtils.copyProperties(rootNode, meta);
            menuVo.setMeta(meta);
            SysMenuVo childrenNode = getChildrenNode(menuVo, list);
            treeList.add(childrenNode);
        }
        return treeList;

    }

    @Override
    public List<MenuTreeVo> queryParentListTree(String nodeId) {
        // 创建根目录节点并将所有数据包裹在其中
        MenuTreeVo root = new MenuTreeVo();
        root.setId(0L); // 根目录ID通常为0
        root.setPid(-1L); // 设置一个无效的值作为根目录的PID
        root.setTitle("根目录"); // 根目录的标题

        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ne(Menu::getMenuType, MenuType.BUTTON.getCode());
        queryWrapper.orderByAsc(Menu::getDeep).orderByAsc(Menu::getSort);
        List<Menu> list = this.list(queryWrapper);
        List<MenuTreeVo> menuTreeVos = BeanCopyUtils.copyList(list, MenuTreeVo.class);

        // 构建树形
        List<MenuTreeVo> tree = TreeUtils.buildTree(menuTreeVos, root, nodeId);
        return tree;
    }

    @Override
    public List<String> getAuthButtonList(Long userId) {
        List<String> permissions = userRoleMapper.queryPermissionByUserId(userId);
        return permissions;
    }

    @Override
    public Long findBtnPermission(Long id, String permission) {
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ne(Menu::getId, id).eq(Menu::getPermission, permission);
        Long count = count(queryWrapper);
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addMenu(MenuDto menuDto) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuDto, menu);
        LambdaQueryWrapper<Menu> queryWrapper;
        // 对非按钮进行唯一性校验
        if (!MenuType.BUTTON.getCode().equals(menu.getMenuType())) {
            queryWrapper = new LambdaQueryWrapper<Menu>().eq(Menu::getName, menu.getName());
            if (this.count(queryWrapper) > 1) {
                throw new AutumnException(ResultCodeEnum.CONFLICT);
            }
            queryWrapper = new LambdaQueryWrapper<Menu>().eq(Menu::getPath, menu.getPath());
            if (this.count(queryWrapper) > 1) {
                throw new AutumnException(ResultCodeEnum.CONFLICT);
            }
        }

        int deep;
        if (isRoot(menu.getPid())) {
            deep = 1;
            menu.setPid(0L);
        } else {
            Integer parentDeep = this.getById(menu.getPid()).getDeep();
            deep = parentDeep + 1;
        }
        menu.setDeep(deep);
        menu.setCreateUser(AuthContextHolder.getUserId());
        menu.setHasChildren(FlagEnum.F.getCode());
        save(menu);

        menuMapper.syncTreeDeep();
        menuMapper.syncTreeHasChildren();
        return true;
    }

    @Override
    public MenuVo detail(Long id) {
        Menu menu = this.getById(id);
        if (menu == null) {
            throw new AutumnException(ResultCodeEnum.NOT_FOUND);
        }
        MenuVo vo = new MenuVo();
        BeanUtils.copyProperties(menu, vo);
        return vo;
    }

    @Override
    public Boolean edit(MenuDto menuDto) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuDto, menu);
        return this.updateById(menu);
    }

    @Override
    @Transactional
    public Boolean delete(SelectIdsDto ids) {
        if (!CollectionUtils.isEmpty(ids.getIds())) {
            // 递归查询下边的子节点id
            List<Long> list = menuMapper.selectMenuAndChildrenIds((List<Long>) ids.getIds());
            menuMapper.updateMenuAndChildrenIsDelete(list);
            menuMapper.syncTreeDeep();
            menuMapper.syncTreeHasChildren();
        }
        return true;
    }

    /**
     * 获取父级跟节点
     *
     * @param list
     * @return
     */
    private List<SysMenuVo> getRootNodes(List<Menu> list) {
        List<SysMenuVo> rootList = new ArrayList<>();
        for (Menu menu : list) {
            if (menu.getPid() == null || menu.getPid().equals(0L)) {
                SysMenuVo vo = new SysMenuVo();
                BeanUtils.copyProperties(menu, vo);
                rootList.add(vo);
            }
        }
        return rootList;
    }

    private SysMenuVo getChildrenNode(SysMenuVo sysMenu, List<Menu> menuList) {
        List<SysMenuVo> childrenList = new ArrayList<>();
        for (Menu menu : menuList) {
            if (menu.getPid().equals(sysMenu.getId())) {
                SysMenuVo childrenNode = new SysMenuVo();
                BeanUtils.copyProperties(menu, childrenNode);
                SysMenuVo.Meta meta = new SysMenuVo.Meta();
                BeanUtils.copyProperties(menu, meta);
                childrenNode.setMeta(meta);
                childrenList.add(getChildrenNode(childrenNode, menuList));
            }
        }
        sysMenu.setChildren(childrenList);
        return sysMenu;
    }

    /**
     * 是否是根节点
     *
     * @param pid 父级Id
     * @return true:是根节点
     */
    private boolean isRoot(Long pid) {
        return pid == null || pid.equals(0L);
    }
}
