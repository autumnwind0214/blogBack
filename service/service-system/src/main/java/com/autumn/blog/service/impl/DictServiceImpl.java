package com.autumn.blog.service.impl;

import com.autumn.blog.common.exception.AutumnException;
import com.autumn.blog.common.result.ResultCodeEnum;
import com.autumn.blog.mapper.DictMapper;
import com.autumn.blog.model.entity.system.Dict;
import com.autumn.blog.model.vo.SysDictVo;
import com.autumn.blog.service.DictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author autumn
 * @description DictServiceImpl
 * @date 2024年11月19日
 * @version: 1.0
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    public Map<String, List<SysDictVo>> loadAllDict() {
        // 查询所有字典
        List<SysDictVo> list = dictMapper.listDict("");
        if (CollectionUtils.isEmpty(list)) {
            throw new AutumnException(ResultCodeEnum.NOT_FOUND);
        }
        Map<String, List<SysDictVo>> result = list.stream().collect(Collectors.groupingBy(SysDictVo::getTypeCode, LinkedHashMap::new, // 使用 LinkedHashMap
                // 作为分组的容器,有序解决乱序问题
                Collectors.toList()));

        return result;
    }
}
