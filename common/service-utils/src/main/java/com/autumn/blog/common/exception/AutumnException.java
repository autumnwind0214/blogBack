package com.autumn.blog.common.exception;

import com.autumn.blog.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * @author autumn
 * @description 自定义全局异常类
 * @date 2024年11月10日
 * @version: 1.0
 */
@Data
public class AutumnException extends RuntimeException {
    private Integer code;
    private String message;

    /**
     * @param code
     * @param message
     * @return null
     * @date 2024/11/10 0:08
     * @description 通过状态码和错误消息创建异常对象
     */
    public AutumnException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public AutumnException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "AutumnException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
