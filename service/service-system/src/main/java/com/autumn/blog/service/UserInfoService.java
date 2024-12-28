package com.autumn.blog.service;

import com.autumn.blog.model.dto.LoginDto;
import com.autumn.blog.model.dto.UserInfoDto;
import com.autumn.blog.model.po.system.UserInfo;
import com.autumn.blog.model.vo.UserInfoVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
public interface UserInfoService extends IService<UserInfo> {

    Page<UserInfoVo> listPage(UserInfoDto form);
}
