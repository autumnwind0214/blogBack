package com.autumn.blog.common.exception;

/**
 * @author autumn
 * @description 通用错误信息
 * @date 2024年12月18日
 * @version: 1.0
 */
public enum CommonError {

    UN_KNOW_ERROR("执行过程异常，请重试。"),
    PARAMS_ERROR("非法参数"),
    OBJECT_NULL("对象为空"),
    QUERY_NULL("查询结果为空"),
    REQUEST_NULL("请求参数为空");

    private String errMessage;

    public String getErrMessage() {
        return errMessage;
    }

    // 单例模式
    private CommonError(String errMessage) {
        this.errMessage = errMessage;
    }
}
