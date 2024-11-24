package com.autumn.blog.common.util;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author autumn
 * @description 拷贝工具类
 * @date 2024年11月20日
 * @version: 1.0
 */
public class BeanCopyUtils {

    private static final ModelMapper modelMapper = new ModelMapper();

    /**
     * list 复制
     *
     * @param sourceList
     * @param targetClass
     * @param <Source>
     * @param <Target>
     * @return
     */
    public static <Source, Target> List<Target> copyList(List<Source> sourceList, Class<Target> targetClass) {
        return sourceList.stream().map(source -> modelMapper.map(source, targetClass)).collect(Collectors.toList());
    }
}
