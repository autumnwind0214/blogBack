package com.autumn.blog.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author autumn
 * @description 获取验证码返回
 * @date 2024年12月27日
 * @version: 1.0
 */
@Data
@AllArgsConstructor
public class CaptchaVo {

    /**
     * 验证码id
     */
    private String captchaId;

    /**
     * 验证码的值
     */
    private String code;

    /**
     * 图片验证码的base64值
     */
    private String imageData;
}
