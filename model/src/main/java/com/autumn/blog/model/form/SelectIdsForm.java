package com.autumn.blog.model.form;

import io.swagger.v3.oas.annotations.media.Schema;
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
public class SelectIdsForm {
    {
        ids = new ArrayList<>();
    }

    @Schema(description = "选择的标识数组")
    private List<? extends Serializable> ids;

    public SelectIdsForm() {
    }

    public SelectIdsForm(List<? extends Serializable> ids) {
        this.ids = ids;
    }
}
