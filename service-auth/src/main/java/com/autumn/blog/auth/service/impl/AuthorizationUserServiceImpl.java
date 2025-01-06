package com.autumn.blog.auth.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.autumn.blog.auth.mapper.AuthorizationUserMapper;
import com.autumn.blog.auth.model.security.CustomGrantedAuthority;
import com.autumn.blog.auth.model.vo.UserDetailsVo;
import com.autumn.blog.auth.service.AuthorizationUserService;
import com.autumn.blog.common.util.BeanCopyUtils;
import com.autumn.blog.model.enums.FlagEnum;
import com.autumn.blog.model.po.auth.Authorization;
import com.autumn.blog.model.po.auth.AuthorizationUser;
import com.autumn.blog.model.po.system.UserInfo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author autumn
 * @description
 * @date 2024年12月21日
 * @version: 1.0
 */
@Service
public class AuthorizationUserServiceImpl extends ServiceImpl<AuthorizationUserMapper, AuthorizationUser> implements AuthorizationUserService {

    @Autowired
    private AuthorizationUserMapper authorizationUserMapper;

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        return null;
    }

    @Override
    public void createUser(UserDetails user) {

    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<AuthorizationUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AuthorizationUser::getUsername, username)
                .or().eq(AuthorizationUser::getEmail, username)
                .or().eq(AuthorizationUser::getPhone, username);
        AuthorizationUser user = authorizationUserMapper.selectOne(queryWrapper);
        Collection<CustomGrantedAuthority> collection = new ArrayList<>();
        // collection.add(new CustomGrantedAuthority("test"));
        String[] authorities=  {"test"};
        if (user == null) {
            throw new UsernameNotFoundException(username);
        } else {
            String password = user.getPassword();
            user.setPassword("");
            UserDetails userDetails = User.withUsername(JSONObject.toJSONString(user)).password(password).authorities(authorities).build();
            // UserDetails userDetails = User.withUsername(username).password(password).authorities(authorities).build();
            return userDetails;
        }
    }
}
