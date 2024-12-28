package com.autumn.blog.service;

import com.autumn.blog.model.dto.MenuDto;
import com.autumn.blog.model.dto.SelectIdsDto;
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

    Boolean addMenu(MenuDto menuDto);

    List<String> getAuthButtonList();

    MenuPermissionVo findBtnPermission(Long id, String permission);

    MenuVo detail(Long id);

    Boolean edit(MenuDto menuDto);

    Boolean delete(SelectIdsDto ids);
}
