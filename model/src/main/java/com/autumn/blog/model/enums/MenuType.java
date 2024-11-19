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
    DIRECTORY(1, "目录", "warning"),
    MENU(2, "菜单", "success"),
    BUTTON(3, "按钮", "danger"),
    ;

    @EnumValue
    private Integer code;
    private String msg;
    private String callbackShowStyle;


    MenuType(Integer code, String msg, String callbackShowStyle) {
        this.code = code;
        this.msg = msg;
        this.callbackShowStyle = callbackShowStyle;
    }

    // 创建一个方法，传入code的值，返回msg
    public static String getMeg(Integer code) {
        for (MenuType menuType : MenuType.values()) {
            if (menuType.getCode().equals(code)) {
                return menuType.getMsg();
            }
        }
        return null; // 如果没有找到匹配的code，返回null或默认值
    }
}
