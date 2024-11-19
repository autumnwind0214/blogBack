package com.autumn.blog.model.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author autumn
 * @description 字典表
 * @date 2024年11月19日
 * @version: 1.0
 */
@Data
public class Dict {

    @TableId(type = IdType.ASSIGN_ID)
    Long id;

    // 字典名称
    String codeName;

    // 排序
    Integer sort;

    // 回显样式
    String callbackShowStyle;

    // 是否锁定
    Byte isLock;
}
