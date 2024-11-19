package com.autumn.blog.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author autumn
 * @description
 * @date 2024年11月19日
 * @version: 1.0
 */
@Data
public class SysDictVo implements Serializable {

    private static final long serialVersionUID = 1L;

    Long id;

    // 字典名称
    String codeName;

    // 排序
    Integer sort;

    // 回显样式
    String callbackShowStyle;

    // 字典类型码
    String typeCode;

    // 字典类型名称
    String typeName;

    // 是否锁定
    Byte isLock;
}
