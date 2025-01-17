package com.autumn.blog.system.client;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.vo.SysDictVo;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * @author autumn
 * @description 远程调用
 * @date 2024年11月15日
 * @version: 1.0
 */
// @FeignClient(value = "service-system")
public interface SysDictFeignClient {
    //
    // @GetMapping("/system/dict/getAllDict")
    // Result<Map<String, List<SysDictVo>>> getAllDict();
}
