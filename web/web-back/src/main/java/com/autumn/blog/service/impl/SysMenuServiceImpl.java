package com.autumn.blog.service.impl;

import com.autumn.blog.common.exception.AutumnException;
import com.autumn.blog.common.result.Result;
import com.autumn.blog.common.result.ResultCodeEnum;
import com.autumn.blog.common.util.AuthContextHolder;
import com.autumn.blog.model.dto.MenuDto;
import com.autumn.blog.model.dto.SelectIdsDto;
import com.autumn.blog.model.vo.*;
import com.autumn.blog.service.SysMenuService;
import com.autumn.blog.system.client.SysMenuFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuFeignClient sysMenuFeignClient;

    @Override
    public List<SysMenuVo> findMenuListByUserId() {

        Long userId = AuthContextHolder.getUserId();
        Result<List<SysMenuVo>> result = sysMenuFeignClient.findMenuListByUserId(userId);
        if (!ResultCodeEnum.isOk(result.getCode())) {
            throw new AutumnException(ResultCodeEnum.BAD_REQUEST);
        }
        List<SysMenuVo> treeList = result.getData();
        return treeList;
    }

    @Override
    public List<SysMenuVo> getMenuList() {
        Result<List<SysMenuVo>> result = sysMenuFeignClient.getMenuList();
        return result.getData();
    }

    @Override
    public List<MenuTreeVo> tree(String nodeId) {
        Result<List<MenuTreeVo>> result = sysMenuFeignClient.queryParentListTree(nodeId);
        return result.getData();
    }

    @Override
    public Boolean addMenu(MenuDto menuDto) {
        Result<Boolean> result = sysMenuFeignClient.addMenu(menuDto);
        return result.getData();
    }

    @Override
    public List<String> getAuthButtonList() {
        Long userId = AuthContextHolder.getUserId();
        Result<List<String>> result = sysMenuFeignClient.getAuthButtonList(userId);
        return result.getData();
    }

    @Override
    public MenuPermissionVo findBtnPermission(Long id, String permission) {
        MenuPermissionVo vo = new MenuPermissionVo();
        if (StringUtils.hasText(permission)) {
            Result<Long> result = sysMenuFeignClient.findBtnPermission(id, permission);
            vo.setPermissionCount(result.getData());
        }
        return vo;
    }

    @Override
    public MenuVo detail(Long id) {
        Result<MenuVo> result = sysMenuFeignClient.detail(id);
        return result.getData();
    }

    @Override
    public Boolean edit(MenuDto menuDto) {
        Result<Boolean> result = sysMenuFeignClient.edit(menuDto);
        return result.getData();
    }

    @Override
    public Boolean delete(SelectIdsDto ids) {
        Result<Boolean> result = sysMenuFeignClient.delete(ids);
        return result.getData();
    }
}
