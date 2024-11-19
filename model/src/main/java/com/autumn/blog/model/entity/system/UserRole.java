package com.autumn.blog.model.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Data
public class UserRole {

    @TableId(type = IdType.ASSIGN_ID)
    Long id;

    Long userId;

    Long roleId;
}
