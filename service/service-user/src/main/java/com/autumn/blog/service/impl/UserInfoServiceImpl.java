package com.autumn.blog.service.impl;

import com.autumn.blog.common.exception.AutumnException;
import com.autumn.blog.common.result.ResultCodeEnum;
import com.autumn.blog.common.util.MD5Utils;
import com.autumn.blog.common.util.UuidUtils;
import com.autumn.blog.mapper.UserInfoMapper;
import com.autumn.blog.model.entity.user.UserInfo;
import com.autumn.blog.model.form.LoginForm;
import com.autumn.blog.model.form.RegisterForm;
import com.autumn.blog.model.vo.UserInfoVo;
import com.autumn.blog.service.UserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfoVo login(LoginForm loginForm) {
        // 根据用户名查找账号信息
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUsername, loginForm.getUsername());
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        if (userInfo == null) {
            throw new AutumnException(ResultCodeEnum.NOT_FOUND, "账号或密码错误");
        }
        String hashPassword = MD5Utils.hashPassword(loginForm.getPassword(), userInfo.getSalt());
        if (!hashPassword.equals(userInfo.getPassword())) {
            throw new AutumnException(ResultCodeEnum.NOT_FOUND,"账号或密码错误");
        }
        UserInfoVo vo = new UserInfoVo();
        BeanUtils.copyProperties(userInfo, vo);
        return vo;
    }

    @Override
    public Boolean register(RegisterForm registerForm) {
        // 校验该用户是否存在
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(UserInfo::getUsername, registerForm.getUsername());
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        if (userInfo != null) {
            throw new AutumnException(ResultCodeEnum.CONFLICT, "该账号已存在");
        }
        userInfo = new UserInfo();
        userInfo.setUsername(registerForm.getUsername());
        String salt = UuidUtils.getUUID();
        userInfo.setSalt(salt);
        // 密码加密
        userInfo.setPassword(MD5Utils.hashPassword(registerForm.getPassword(), salt));

        return userInfoMapper.insert(userInfo) > 1;
    }
}
