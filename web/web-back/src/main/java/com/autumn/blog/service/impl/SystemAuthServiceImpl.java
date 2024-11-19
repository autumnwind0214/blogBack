package com.autumn.blog.service.impl;

import com.autumn.blog.common.constant.RedisConstant;
import com.autumn.blog.common.exception.AutumnException;
import com.autumn.blog.common.result.Result;
import com.autumn.blog.common.result.ResultCodeEnum;
import com.autumn.blog.common.util.AuthContextHolder;
import com.autumn.blog.model.entity.system.Dict;
import com.autumn.blog.model.vo.SysDictVo;
import com.autumn.blog.model.vo.SysMenuVo;
import com.autumn.blog.service.SystemAuthService;
import com.autumn.blog.system.client.SystemFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.autumn.blog.common.constant.RedisConstant.SYS_DICT_KEY_TIMEOUT;

/**
 * @author autumn
 * @description
 * @date 2024年11月15日
 * @version: 1.0
 */
@Service
public class SystemAuthServiceImpl implements SystemAuthService {

    @Autowired
    private SystemFeignClient systemFeignClient;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<SysMenuVo> findMenuListByUserId() {

        Long userId = AuthContextHolder.getUserId();
        Result<List<SysMenuVo>> result = systemFeignClient.findMenuListByUserId(userId);
        if (!ResultCodeEnum.SUCCESS.getCode().equals(result.getCode())) {
            throw new AutumnException(ResultCodeEnum.DATA_ERROR);
        }
        List<SysMenuVo> treeList = result.getData();
        return treeList;
    }

    @Override
    public List<SysMenuVo> getMenuList() {
        Result<List<SysMenuVo>> result = systemFeignClient.getMenuList();
        return result.getData();
    }

    @Override
    public Map<String, List<SysDictVo>> getAllDict() {
        if (redisTemplate.hasKey(RedisConstant.SYS_DICT)) {
            return redisTemplate.opsForHash().entries(RedisConstant.SYS_DICT);
        }
        Result<Map<String, List<SysDictVo>>> result = systemFeignClient.getAllDict();
        if (!result.getCode().equals(ResultCodeEnum.SUCCESS.getCode())) {
            throw new AutumnException(ResultCodeEnum.DATA_ERROR);
        }
        redisTemplate.opsForHash().putAll(RedisConstant.SYS_DICT, result.getData());
        redisTemplate.expire(RedisConstant.SYS_DICT, SYS_DICT_KEY_TIMEOUT, TimeUnit.HOURS);
        return result.getData();
    }
}
