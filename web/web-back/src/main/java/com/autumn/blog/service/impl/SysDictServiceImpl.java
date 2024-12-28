package com.autumn.blog.service.impl;

import com.autumn.blog.common.constant.RedisConstant;
import com.autumn.blog.common.exception.AutumnException;
import com.autumn.blog.common.result.Result;
import com.autumn.blog.common.result.ResultCodeEnum;
import com.autumn.blog.model.vo.SysDictVo;
import com.autumn.blog.service.SysDictService;
import com.autumn.blog.system.client.SysDictFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SysDictServiceImpl implements SysDictService {

    @Autowired
    private SysDictFeignClient sysDictFeignClient;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Map<String, List<SysDictVo>> getAllDict() {
        if (redisTemplate.hasKey(RedisConstant.SYS_DICT)) {
            return redisTemplate.opsForHash().entries(RedisConstant.SYS_DICT);
        }
        Result<Map<String, List<SysDictVo>>> result = sysDictFeignClient.getAllDict();
        if (!ResultCodeEnum.isOk(result.getCode())) {
            throw new AutumnException(ResultCodeEnum.NOT_FOUND);
        }
        redisTemplate.opsForHash().putAll(RedisConstant.SYS_DICT, result.getData());
        redisTemplate.expire(RedisConstant.SYS_DICT, SYS_DICT_KEY_TIMEOUT, TimeUnit.HOURS);
        return result.getData();
    }
}
