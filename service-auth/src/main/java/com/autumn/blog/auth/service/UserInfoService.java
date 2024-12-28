package com.autumn.blog.auth.service;

import com.autumn.blog.model.po.system.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 * @author autumn
 * @description TODO
 * @date 2024年12月21日
 * @version: 1.0
 */
public interface UserInfoService extends IService<UserInfo>, UserDetailsManager, UserDetailsPasswordService {
}
