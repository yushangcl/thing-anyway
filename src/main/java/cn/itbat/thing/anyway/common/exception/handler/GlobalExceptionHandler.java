package cn.itbat.thing.anyway.common.exception.handler;

import cn.itbat.thing.anyway.common.base.BaseResponse;
import cn.itbat.thing.anyway.common.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author huahui.wu
 * @date 2018/8/13 13:48
 * @description
 */
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 业务异常
     */
    @ExceptionHandler(BaseException.class)
    public BaseResponse baseExceptionHandler(BaseException ex) {
        logger.error(ex.getMessage(), ex);
        return new BaseResponse(ex.getStatus(), ex.getMessage());
    }

    /**
     * 500- server error
     */
    @ExceptionHandler(Exception.class)
    public BaseResponse otherExceptionHandler(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return new BaseResponse(500, "系统繁忙 " + ex.toString());
    }

    /**
     * 缺少请求参数- Bad Request
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public BaseResponse handleMissingServletRequestParameterException(
            MissingServletRequestParameterException ex) {
        logger.error(ex.getMessage(), ex);
        return new BaseResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    /**
     * 参数绑定失败- Bad Request
     */
    @ExceptionHandler(BindException.class)
    public BaseResponse handleBindException(BindException ex) {
        logger.error(ex.getMessage(), ex);
        return new BaseResponse(HttpStatus.BAD_REQUEST.value(),
                ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    /**
     * 参数验证失败 - Bad Request
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.error(ex.getMessage(), ex);
        return new BaseResponse(HttpStatus.BAD_REQUEST.value(),
                ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
