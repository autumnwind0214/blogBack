package com.autumn.blog.common.result;

import lombok.Getter;

/**
 * 统一返回结果状态信息类
 *
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"成功"),
    FAIL(201, "失败"),
    ACCOUNT_EXIST(202, "该账号已存在"),
    ACCOUNT_NOT_EXIST(203, "该账号不存在"),
    ACCOUNT_ERROR(204, "账号或密码错误"),


    ;

    private Integer code;

    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
