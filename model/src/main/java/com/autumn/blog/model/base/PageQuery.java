package com.autumn.blog.model.base;

import lombok.Data;

/**
 * @author autumn
 * @description 分页查询基础类
 * @date 2024年11月24日
 * @version: 1.0
 */
@Data
public class PageQuery {

    {
        page = 1;
        size = 10;
    }

    // 页数
    private Integer page;

    // 每页条数
    private Integer size;
}
