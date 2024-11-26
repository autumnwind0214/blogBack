package com.autumn.blog.service;

import com.autumn.blog.model.form.MenuForm;
import com.autumn.blog.model.form.SelectIdsForm;
import com.autumn.blog.model.vo.*;

import java.util.List;

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

    Boolean addMenu(MenuForm menuForm);

    List<String> getAuthButtonList();

    MenuPermissionVo findBtnPermission(Long id, String permission);

    MenuVo detail(Long id);

    Boolean edit(MenuForm menuForm);

    Boolean delete(SelectIdsForm ids);
}
