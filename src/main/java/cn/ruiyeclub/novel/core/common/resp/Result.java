package cn.ruiyeclub.novel.core.common.resp;

import cn.ruiyeclub.novel.core.common.constant.ErrorCodeEnum;
import lombok.Getter;

import java.util.Objects;

/**
 * @author: Cr.
 * @date: 2022/6/14
 */
@Getter
public class Result<T> {

    /**
     * 响应码
     */
    private String code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    private Result() {
        this.code = ErrorCodeEnum.OK.getCode();
        this.message = ErrorCodeEnum.OK.getMessage();
    }

    private Result(ErrorCodeEnum errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    private Result(T data) {
        this.data = data;
    }

    /**
     * 业务处理成功，无数据返回
     */
    public static Result<Void> success() {
        return new Result<>();
    }

    /**
     * 业务处理成功，有数据返回
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(data);
    }

    /**
     * 业务处理失败
     */
    public static Result<Void> failure(ErrorCodeEnum errorCode) {
        return new Result<>(errorCode);
    }

    /**
     * 系统错误
     */
    public static Result<Void> error() {
        return new Result<>(ErrorCodeEnum.SYSTEM_ERROR);
    }

    /**
     * 判断是否成功
     */
    public Boolean isSuccess() {
        return Objects.equals(this.code, ErrorCodeEnum.OK.getCode());
    }
}
