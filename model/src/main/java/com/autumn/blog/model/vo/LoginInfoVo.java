package com.autumn.blog.model.vo;

import com.autumn.blog.model.po.system.UserInfo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Data
public class LoginInfoVo extends UserInfo {
    String name;
    String accessToken;

    //用户权限
    List<String> permissions = new ArrayList<>();
}
