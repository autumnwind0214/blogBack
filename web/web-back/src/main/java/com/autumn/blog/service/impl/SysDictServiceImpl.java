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

}
