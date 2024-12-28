package com.autumn.blog.service.impl;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.dto.UserInfoDto;
import com.autumn.blog.model.vo.UserInfoVo;
import com.autumn.blog.service.UserInfoService;
import com.autumn.blog.system.client.UserInfoFeignClient;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoFeignClient userInfoFeignClient;

    @Override
    public Page<UserInfoVo> listPage(UserInfoDto form) {
        Result<Page<UserInfoVo>> result = userInfoFeignClient.listPage(form);
        return result.getData();
    }
}
