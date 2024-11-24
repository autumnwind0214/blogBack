package com.autumn.blog.service.impl;

import com.autumn.blog.common.constant.RedisConstant;
import com.autumn.blog.common.exception.AutumnException;
import com.autumn.blog.common.result.Result;
import com.autumn.blog.common.result.ResultCodeEnum;
import com.autumn.blog.common.util.AuthContextHolder;
import com.autumn.blog.common.util.TreeUtils;
import com.autumn.blog.model.form.MenuAddForm;
import com.autumn.blog.model.vo.MenuPermissionVo;
import com.autumn.blog.model.vo.MenuTreeVo;
import com.autumn.blog.model.vo.SysDictVo;
import com.autumn.blog.model.vo.SysMenuVo;
import com.autumn.blog.service.SysMenuService;
import com.autumn.blog.system.client.SysMenuFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.autumn.blog.common.constant.RedisConstant.SYS_DICT_KEY_TIMEOUT;

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
    public Boolean addMenu(MenuAddForm menuAddForm) {
        Result<Boolean> result = sysMenuFeignClient.addMenu(menuAddForm);
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
}