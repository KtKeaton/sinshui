package project.handler;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import project.data.base.ResponseData;
import project.enums.ResponseCode;
import project.exception.GlobalRuntimeException;

@RestControllerAdvice
@Slf4j
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseData<String> handleExceptions(Exception exception, WebRequest webRequest) {
        log.error("Exception: ", exception);
        return ResponseData.response(ResponseCode.SERVER_ERROR, null);
    }

    @ExceptionHandler(GlobalRuntimeException.class)
    public ResponseData<String> handleGlobalRuntimeExceptions(GlobalRuntimeException exception, WebRequest webRequest) {
        log.error("GlobalRuntimeException: ", exception);
        return ResponseData.response(exception.getResponseCode(), null);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseData<String> handleConstraintViolationException(ConstraintViolationException exception, WebRequest webRequest) {
        log.error("ConstraintViolationException: ", exception);
        return ResponseData.response(ResponseCode.CONSTRAINT_VIOLATION_ERROR, exception.getMessage());
    }
}
