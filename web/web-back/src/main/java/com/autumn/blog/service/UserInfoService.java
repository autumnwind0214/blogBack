package com.autumn.blog.service;

import com.autumn.blog.model.dto.LoginDto;
import com.autumn.blog.model.dto.UserInfoDto;
import com.autumn.blog.model.vo.LoginInfoVo;
import com.autumn.blog.model.vo.UserInfoVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
public interface UserInfoService {

    Page<UserInfoVo> listPage(UserInfoDto form);
}
