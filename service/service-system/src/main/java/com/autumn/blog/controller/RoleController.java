package com.autumn.blog.controller;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.form.RoleForm;
import com.autumn.blog.model.vo.RoleVo;
import com.autumn.blog.service.DictService;
import com.autumn.blog.service.RoleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author autumn
 * @description DictController
 * @date 2024年11月19日
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/system/role")
@SuppressWarnings({"unchecked", "rawtypes"})
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/listPage")
    public Result<Page<RoleVo>> listPage(@RequestBody RoleForm form) {
        return Result.success(roleService.listPage(form));
    }

}
