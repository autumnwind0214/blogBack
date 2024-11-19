package com.autumn.blog.mapper;

import com.autumn.blog.model.entity.system.Dict;
import com.autumn.blog.model.vo.SysDictVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author autumn
 * @description DictMapper
 * @date 2024年11月19日
 * @version: 1.0
 */
@Mapper
public interface DictMapper extends BaseMapper<Dict> {

    List<SysDictVo> listDict(@Param("typeCode") String typeCode);
}
