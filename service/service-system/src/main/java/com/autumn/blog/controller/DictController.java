package com.autumn.blog.controller;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.vo.SysDictVo;
import com.autumn.blog.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author autumn
 * @description DictController
 * @date 2024年11月19日
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/dict")
@SuppressWarnings({"unchecked", "rawtypes"})
public class DictController {

    @Autowired
    private DictService dictService;

    @GetMapping("/getAllDict")
    public Result<Map<String, List<SysDictVo>>> getAllDict() {
        return Result.success(dictService.loadAllDict());
    }

}
