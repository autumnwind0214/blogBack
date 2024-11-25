package com.autumn.blog.model.entity.system;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author autumn
 * @description 角色
 * @date 2024年11月14日
 * @version: 1.0
 */
@Data
public class Role {
    @TableId(type = IdType.ASSIGN_ID)
    Long id;
    String roleName;
    Byte isLock;
    String permission;

    @TableField(fill = FieldFill.INSERT)
    LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    LocalDateTime updateTime;

}
