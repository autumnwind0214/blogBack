package com.autumn.blog.service;

import com.autumn.blog.model.form.MenuAddForm;
import com.autumn.blog.model.vo.MenuPermissionVo;
import com.autumn.blog.model.vo.MenuTreeVo;
import com.autumn.blog.model.vo.SysDictVo;
import com.autumn.blog.model.vo.SysMenuVo;

import java.util.List;
import java.util.Map;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
public interface SysMenuService {
    List<SysMenuVo> findMenuListByUserId();

    List<SysMenuVo> getMenuList();

    List<MenuTreeVo> tree(String nodeId);

    Boolean addMenu(MenuAddForm menuAddForm);

    List<String> getAuthButtonList();

    MenuPermissionVo findBtnPermission(Long id, String permission);
}
