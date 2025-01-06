package com.autumn.blog.system.client;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.dto.RoleDto;
import com.autumn.blog.model.dto.RoleMenuDto;
import com.autumn.blog.model.vo.RoleMenuVo;
import com.autumn.blog.model.vo.RoleVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author autumn
 * @description 远程调用
 * @date 2024年11月15日
 * @version: 1.0
 */
// @FeignClient(value = "service-system")
public interface SysRoleFeignClient {

    // @PostMapping("/system/role/listPage")
    // Result<Page<RoleVo>> listPage(@RequestBody RoleDto form);
    //
    // @GetMapping("/system/role/getRoleMenus/{roleId}")
    // Result<RoleMenuVo> getRoleMenus(@PathVariable Long roleId);
    //
    // @PutMapping("/system/role/setRoleMenus")
    // Result<Boolean> setRoleMenus(@RequestBody RoleMenuDto form);
}
