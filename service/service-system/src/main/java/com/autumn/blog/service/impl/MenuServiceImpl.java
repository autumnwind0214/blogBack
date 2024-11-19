package com.autumn.blog.service.impl;

import com.autumn.blog.mapper.MenuMapper;
import com.autumn.blog.mapper.UserRoleMapper;
import com.autumn.blog.model.entity.system.Menu;
import com.autumn.blog.model.enums.MenuType;
import com.autumn.blog.model.vo.SysMenuVo;
import com.autumn.blog.service.MenuService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
            queryWrapper.in(Menu::getId, menuIds).orderByAsc(Menu::getDeep).orderByAsc(Menu::getSort);
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
}
