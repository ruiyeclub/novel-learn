package cn.ruiyeclub.novel.core.common.exception;

import cn.ruiyeclub.novel.core.common.constant.ErrorCodeEnum;
import cn.ruiyeclub.novel.core.common.resp.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 通用的异常处理器
 *
 * @author: Cr.
 * @date: 2022/6/15
 */
@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

    /**
     * 处理数据校验异常
     */
    @ExceptionHandler(BindException.class)
    public Result<Void> handlerBindException(BindException e) {
        log.error(e.getMessage(), e);
        return Result.failure(ErrorCodeEnum.USER_REQUEST_PARAM_ERROR);
    }

    /**
     * 处理业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Result<Void> handlerBusinessException(BusinessException e) {
        log.error(e.getMessage(), e);
        return Result.failure(e.getErrorCodeEnum());
    }

    /**
     * 处理系统异常
     */
    @ExceptionHandler(Exception.class)
    public Result<Void> handlerException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error();
    }
}
