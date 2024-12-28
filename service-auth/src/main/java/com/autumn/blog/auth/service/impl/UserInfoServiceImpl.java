package com.autumn.blog.auth.service.impl;

import com.autumn.blog.auth.mapper.UserInfoMapper;
import com.autumn.blog.auth.service.UserInfoService;
import com.autumn.blog.model.po.system.UserInfo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author autumn
 * @description
 * @date 2024年12月21日
 * @version: 1.0
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

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
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUsername, username);
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        // Collection<GrantedAuthority> collection = new ArrayList<>();
        String[] authorities=  {"test"};
        if (userInfo == null) {
            throw new UsernameNotFoundException(username);
        } else {
            String password = userInfo.getPassword();
            userInfo.setPassword("");
            // UserDetails userDetails = new User(userInfo.getUsername(), userInfo.getPassword(), collection);
            UserDetails userDetails = User.withUsername(username).password(password).authorities(authorities).build();
            return userDetails;
        }
    }
}
