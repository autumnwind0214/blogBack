package com.autumn.blog.service.impl;

import com.autumn.blog.common.exception.AutumnException;
import com.autumn.blog.common.result.ResultCodeEnum;
import com.autumn.blog.common.util.MD5Utils;
import com.autumn.blog.common.util.UuidUtils;
import com.autumn.blog.mapper.UserInfoMapper;
import com.autumn.blog.mapper.UserRoleMapper;
import com.autumn.blog.model.dto.LoginDto;
import com.autumn.blog.model.dto.UserInfoDto;
import com.autumn.blog.model.po.system.UserInfo;
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
    public Page<UserInfoVo> listPage(UserInfoDto form) {
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
