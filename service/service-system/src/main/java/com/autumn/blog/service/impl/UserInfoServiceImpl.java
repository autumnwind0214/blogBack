package com.autumn.blog.service.impl;

import com.autumn.blog.common.exception.AutumnException;
import com.autumn.blog.common.result.ResultCodeEnum;
import com.autumn.blog.common.util.MD5Utils;
import com.autumn.blog.common.util.UuidUtils;
import com.autumn.blog.mapper.UserInfoMapper;
import com.autumn.blog.mapper.UserRoleMapper;
import com.autumn.blog.model.entity.system.UserInfo;
import com.autumn.blog.model.form.LoginForm;
import com.autumn.blog.model.form.RegisterForm;
import com.autumn.blog.model.form.UserInfoForm;
import com.autumn.blog.model.vo.UserInfoVo;
import com.autumn.blog.model.vo.UserRoleVo;
import com.autumn.blog.service.UserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Autowired
    private UserRoleMapper userRoleMapper;

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
            throw new AutumnException(ResultCodeEnum.NOT_FOUND, "账号或密码错误");
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

    @Override
    public Page<UserInfoVo> listPage(UserInfoForm form) {
        Page<UserInfoVo> page = new Page<>(form.getPage(), form.getSize());
        Page<UserInfoVo> pageInfo = userInfoMapper.listPage(page, form);
        List<UserInfoVo> list = setUserRoleInfo(pageInfo.getRecords());
        pageInfo.setRecords(list);
        return pageInfo;
    }

    private List<UserInfoVo> setUserRoleInfo(List<UserInfoVo> list) {
        if (list.isEmpty()) {
            return list;
        }

        // 获取所有用户的 ID 列表
        List<Long> userIds = list.stream().map(UserInfoVo::getId).collect(Collectors.toList());

        // 查询用户的角色信息并转换为 Map
        Map<Long, UserRoleVo> userRoleMap = new HashMap<>();
        List<UserRoleVo> userRoletList = userRoleMapper.queryUserRoleInfo(userIds);
        if (userRoletList != null) {
            for (UserRoleVo vo : userRoletList) {
                userRoleMap.put(vo.getUserId(), vo);
            }
        }
        // 遍历用户列表，设置用户的部门信息
        for (UserInfoVo user : list) {
            // 检查部门信息是否存在
            if (userRoleMap.containsKey(user.getId())) {
                UserRoleVo infoVO = userRoleMap.get(user.getId());
                user.setRoleInfo(infoVO.getRoleInfos());
                user.setRoleIds(infoVO.getRoleIds());
            }
        }
        return list;
    }
}
