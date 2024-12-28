package com.autumn.blog.system.client;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.dto.MenuDto;
import com.autumn.blog.model.dto.SelectIdsDto;
import com.autumn.blog.model.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author autumn
 * @description 远程调用
 * @date 2024年11月15日
 * @version: 1.0
 */
@FeignClient(value = "service-system")
public interface SysMenuFeignClient {

    @GetMapping("/system/menu/queryMenuByUserId/{userId}")
    Result<List<SysMenuVo>> findMenuListByUserId(@PathVariable Long userId);

    @GetMapping("/system/menu/getMenuList")
    Result<List<SysMenuVo>> getMenuList();

    @GetMapping("/system/menu/queryParentListTree")
    Result<List<MenuTreeVo>> queryParentListTree(@RequestParam(required = false) String nodeId);

    @GetMapping("/system/menu/getAuthButtonList/{userId}")
    Result<List<String>> getAuthButtonList(@PathVariable Long userId);

    @GetMapping("/system/menu/findBtnPermission")
    Result<Long> findBtnPermission(@RequestParam(required = false) Long id,
                                               @RequestParam(required = false) String permission);

    @PostMapping("/system/menu/add")
    Result<Boolean> addMenu(@RequestBody MenuDto menuDto);

    @GetMapping("/system/menu/detail/{id}")
    Result<MenuVo> detail(@PathVariable Long id);

    @PutMapping("/system/menu/edit")
    Result<Boolean> edit(@RequestBody MenuDto menuDto);

    @DeleteMapping("/system/menu/delete")
    Result<Boolean> delete(@RequestBody SelectIdsDto ids);
}
