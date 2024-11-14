package com.autumn.blog.model.entity;


import lombok.Data;

/**
 * @author autumn
 * @description 账户
 * @date 2024年11月09日
 * @version: 1.0
 */
@Data
public class Account {

    String username;
    String password;
    String salt;
}
