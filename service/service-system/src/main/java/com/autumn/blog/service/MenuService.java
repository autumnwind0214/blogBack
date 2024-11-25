package com.autumn.blog.service;

import com.autumn.blog.model.entity.system.Menu;
import com.autumn.blog.model.form.MenuAddForm;
import com.autumn.blog.model.vo.MenuPermissionVo;
import com.autumn.blog.model.vo.MenuTreeVo;
import com.autumn.blog.model.vo.MenuVo;
import com.autumn.blog.model.vo.SysMenuVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
public interface MenuService extends IService<Menu> {
    List<SysMenuVo> queryMenuByUserId(Long userId);

    List<SysMenuVo> getMenuList();

    List<MenuTreeVo> queryParentListTree(String nodeId);

    List<String> getAuthButtonList(Long userId);

    Long findBtnPermission(Long id, String permission);

    Boolean addMenu(MenuAddForm menuAddForm);

    MenuVo detail(Long id);
}
