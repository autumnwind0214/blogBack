package com.autumn.blog.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author autumn
 */

@Getter
public enum FlagEnum {
    F((byte) 0, "否"),
    T((byte) 1, "是"),
    ;

    @EnumValue
    private Byte code;
    private String msg;


    FlagEnum(Byte code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
