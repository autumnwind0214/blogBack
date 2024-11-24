package com.autumn.blog.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author autumn
 * @description 菜单类型
 * @date 2024年11月17日
 * @version: 1.0
 */
@Getter
public enum MenuType {
    DIRECTORY(1000001, "目录"),
    MENU(1000002, "菜单"),
    BUTTON(1000003, "按钮"),
    ;

    @EnumValue
    private Integer code;
    private String msg;


    MenuType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
