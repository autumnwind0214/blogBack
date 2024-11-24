package com.autumn.blog.common.result;

import lombok.Getter;

/**
 * 统一返回结果状态信息类
 */
@Getter
public enum ResultCodeEnum {

    // 2XX 请求成功
    SUCCESS(200, "成功"),

    // 3XX重定向
    FAIL(400, "错误请求"),


    // 4XX 客户端错误
    // 客户端错误响应
    BAD_REQUEST(400, "错误请求"),
    UNAUTHORIZED(401, "未经授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "未找到"),
    METHOD_NOT_ALLOWED(405, "方法禁用"),
    NOT_ACCEPTABLE(406, "不接受"),
    CONFLICT (409, "请求冲突"),
    UNSUPPORTED_MEDIA_TYPE(415, "不支持的媒体类型"),

    // 服务器错误响应
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),

    // 5XX 服务端错误


    ;

    private Integer code;

    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static boolean isOk(Integer code) {
        return SUCCESS.getCode().equals(code);
    }
}
