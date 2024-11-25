package com.autumn.blog.system.client;

import com.autumn.blog.common.result.Result;
import com.autumn.blog.model.form.RoleForm;
import com.autumn.blog.model.vo.RoleVo;
import com.autumn.blog.model.vo.SysDictVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * @author autumn
 * @description 远程调用
 * @date 2024年11月15日
 * @version: 1.0
 */
@FeignClient(value = "service-system")
public interface SysRoleFeignClient {

    @PostMapping("/system/role/listPage")
    Result<Page<RoleVo>> listPage(@RequestBody RoleForm form);
}
