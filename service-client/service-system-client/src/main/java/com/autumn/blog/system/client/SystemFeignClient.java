package com.autumn.blog.system.client;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.entity.system.Dict;
import com.autumn.blog.model.vo.SysDictVo;
import com.autumn.blog.model.vo.SysMenuVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * @author autumn
 * @description 远程调用
 * @date 2024年11月15日
 * @version: 1.0
 */
@FeignClient(value = "service-system")
public interface SystemFeignClient {

    @GetMapping("/system/menu/queryMenuByUserId/{userId}")
    Result<List<SysMenuVo>> findMenuListByUserId(@PathVariable Long userId);

    @GetMapping("/system/menu/getMenuList")
    Result<List<SysMenuVo>> getMenuList();

    @GetMapping("/system/dict/getAllDict")
    Result<Map<String, List<SysDictVo>>> getAllDict();
}
