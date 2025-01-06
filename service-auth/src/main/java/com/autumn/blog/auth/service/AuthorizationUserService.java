package com.autumn.blog.auth.service;

import com.autumn.blog.model.po.auth.AuthorizationUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 * @author autumn
 * @description 基础用户信息接口
 * @date 2024年12月21日
 * @version: 1.0
 */
public interface AuthorizationUserService extends IService<AuthorizationUser>, UserDetailsManager, UserDetailsPasswordService {
}
