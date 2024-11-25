package com.autumn.blog.common.base;

import java.util.List;

/**
 * @author autumn
 * @description TreeAble
 * @date 2024年11月20日
 * @version: 1.0
 */
public interface TreeAble<T> {
    Object getId();

    Object getPid();

    Integer getDeep();

    Integer getSort();

    List<T> getChildren();

    void setChildren(List<T> children);
}
