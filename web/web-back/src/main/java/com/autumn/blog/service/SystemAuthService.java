package com.autumn.blog.service;

import com.autumn.blog.model.entity.system.Dict;
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
public interface SystemAuthService {
    List<SysMenuVo> findMenuListByUserId();

    List<SysMenuVo> getMenuList();

    Map<String, List<SysDictVo>> getAllDict();
}
