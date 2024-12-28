package com.autumn.blog.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author autumn
 * @description TODO
 * @date 2024年11月26日
 * @version: 1.0
 */
@Data
public class SelectIdsDto {
    {
        ids = new ArrayList<>();
    }

    // 选择的标识数组
    private List<? extends Serializable> ids;

    public SelectIdsDto() {
    }

    public SelectIdsDto(List<? extends Serializable> ids) {
        this.ids = ids;
    }
}
