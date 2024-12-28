package com.autumn.blog.controller;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.vo.SysDictVo;
import com.autumn.blog.service.SysDictService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Slf4j
@Tag(name = "后台API接口管理")
@RestController
@RequestMapping("/dict")
@SuppressWarnings({"unchecked", "rawtypes"})
public class SysDictController {

    @Autowired
    private SysDictService sysDictService;

    // @LoginVerify
    @Operation(summary = "获取所有字典信息")
    @GetMapping("/getAllDict")
    public Result<Map<String, List<SysDictVo>>> getAllDict() {
        return Result.success(sysDictService.getAllDict());
    }

}
