package com.autumn.blog.common.exception;

import com.autumn.blog.common.result.Result;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author autumn
 * @description 全局异常处理器
 * @date 2024年12月18日
 * @version: 1.0
 */
@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final List<CustomExceptionResolver> exceptionResolvers;

    @ResponseBody
    @ExceptionHandler(AutumnException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<String> customException(AutumnException e) {
        log.error("【系统异常】{}", e.getMessage(), e);
        return Result.fail(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<String> exception(Exception e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.error("【系统异常】{}", e.getMessage());
        // e.printStackTrace();
        log.warn("【请求信息-RequestURL】 {}", request.getRequestURL());

        // 获取所有查询参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (String key : parameterMap.keySet()) {
            String[] values = parameterMap.get(key);
            log.warn("Parameter: {} , values: {}", key, Arrays.toString(values));
        }

        // 逐个检查扩展的异常解析器是否支持当前异常
        for (CustomExceptionResolver resolver : exceptionResolvers) {
            if (resolver.supports(e)) {
                return resolver.resolve(e);
            }
        }
        return Result.fail(CommonError.UN_KNOW_ERROR.getErrMessage());
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<String> msgList = new ArrayList<>();
        // 将错误信息放在msgList
        bindingResult.getFieldErrors().stream().forEach(item -> msgList.add(item.getDefaultMessage()));
        // 拼接错误信息
        String msg = StringUtils.join(msgList, ",");
        log.error("【系统异常】{}", msg);
        return Result.fail(msg);
    }
}
