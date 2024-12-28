package com.autumn.blog.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author autumn
 * @description Entity基类
 * @date 2024年11月09日
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 雪花算法ID,64bit
     * 第一个部分是1bit, 这不 使用,没有意义;
     * 第二个部分是41bit, 组成时间戳;
     * 第三个部分是10bit, 工作机器ID,里面分为两个部分,5个bit是的是机房号,代表最多有25即32个机房,5个bit是指机器的ID,代表最多有25个机器,即32个机器。
     * 第四部分是12bit, 代表是同一个毫秒类产生不同的ID,区分同一个毫秒内产生的ID。
     **/
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 创建时间 自动填充
     */
    @TableField(fill = FieldFill.INSERT)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新时间 自动填充
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 逻辑删除
     **/
    @TableLogic
    private Byte flag;

    private Long createUser;
    private Long updateUser;
}
