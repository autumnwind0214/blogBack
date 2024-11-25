package com.autumn.blog.service.impl;

import com.autumn.blog.common.util.BeanCopyUtils;
import com.autumn.blog.mapper.RoleMapper;
import com.autumn.blog.mapper.RoleMenuMapper;
import com.autumn.blog.model.entity.system.Role;
import com.autumn.blog.model.entity.system.RoleMenu;
import com.autumn.blog.model.form.RoleForm;
import com.autumn.blog.model.form.RoleMenuForm;
import com.autumn.blog.model.vo.MenuTreeVo;
import com.autumn.blog.model.vo.RoleMenuVo;
import com.autumn.blog.model.vo.RoleVo;
import com.autumn.blog.model.vo.SysMenuVo;
import com.autumn.blog.service.MenuService;
import com.autumn.blog.service.RoleMenuService;
import com.autumn.blog.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * @author autumn
 * @description RoleServiceImpl
 * @date 2024年11月15日
 * @version: 1.0
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public Page<RoleVo> listPage(RoleForm form) {
        Page<RoleVo> page = new Page<>(form.getPage(), form.getSize());
        return roleMapper.listPage(page, form);
    }

    @Override
    public RoleMenuVo getRoleMenus(Long roleId) {
        // 获取所有的菜单
        List<SysMenuVo> menuList = menuService.getMenuList();
        List<MenuTreeVo> menuTreeVos = BeanCopyUtils.copyList(menuList, MenuTreeVo.class);

        // 获取角色所绑定的菜单
        LambdaQueryWrapper<RoleMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(RoleMenu::getMenuId).eq(RoleMenu::getRoleId, roleId);
        List<RoleMenu> list = roleMenuService.list(queryWrapper);
        List<Long> selectIds = new ArrayList<>();
        if (!CollectionUtils.isEmpty(list)) {
            selectIds = list.stream().map(RoleMenu::getMenuId).collect(Collectors.toList());
        }
        RoleMenuVo vo = new RoleMenuVo();
        vo.setMenuLists(menuTreeVos);
        vo.setSelectIds(selectIds);
        return vo;
    }

    @Override
    @Transactional
    public Boolean setRoleMenus(RoleMenuForm form) {
        // 删除当前角色下的所有记录
        LambdaQueryWrapper<RoleMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoleMenu::getRoleId, form.getRoleId());
        roleMenuService.remove(queryWrapper);

        if (!CollectionUtils.isEmpty(form.getMenuIds())) {
            List<RoleMenu> list = new ArrayList<>();
            form.getMenuIds().forEach(item -> {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setMenuId(item);
                roleMenu.setRoleId(form.getRoleId());
                list.add(roleMenu);
            });
            roleMenuService.saveBatch(list);
        }
        return true;
    }
}
