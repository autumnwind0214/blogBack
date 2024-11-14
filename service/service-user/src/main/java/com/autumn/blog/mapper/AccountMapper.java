package com.autumn.blog.mapper;

import com.autumn.blog.model.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author autumn
 * @description
 * @date 2024年11月11日
 * @version: 1.0
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
