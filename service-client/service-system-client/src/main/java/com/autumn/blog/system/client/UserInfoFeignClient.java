package com.autumn.blog.system.client;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.po.system.UserInfo;
import com.autumn.blog.model.dto.LoginDto;
import com.autumn.blog.model.dto.UserInfoDto;
import com.autumn.blog.model.vo.UserInfoVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author autumn
 * @description 远程调用
 * @date 2024年11月15日
 * @version: 1.0
 */
@FeignClient(value = "service-system")
public interface UserInfoFeignClient {

    @PostMapping("/system/userinfo/listPage")
    Result<Page<UserInfoVo>> listPage(@RequestBody UserInfoDto form);

    @GetMapping("/system/userinfo/getUserInfoByUserName/{username}")
    Result<UserInfo> getUserInfoByUserName(@PathVariable String username);
}
