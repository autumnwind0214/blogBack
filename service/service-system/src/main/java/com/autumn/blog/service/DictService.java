package com.autumn.blog.service;

import com.autumn.blog.model.po.system.Dict;
import com.autumn.blog.model.vo.SysDictVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * @author autumn
 * @description DictService
 * @date 2024年11月19日
 * @version: 1.0
 */
public interface DictService extends IService<Dict> {
    Map<String, List<SysDictVo>> loadAllDict();
}
