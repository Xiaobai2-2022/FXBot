package com.fangxia.fxbot.advice;
import com.fangxia.fxbot.common.FXApiResponse;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class FXExceptionHandlerAdvice {

    @ExceptionHandler(DuplicateKeyException.class)
    public FXApiResponse<?> handleDuplicateKeyException(DuplicateKeyException ex) {

        Throwable cause = ex.getMostSpecificCause();
        String causeMsg = cause.getMessage();
        return FXApiResponse.failure(
                Objects.requireNonNullElseGet(
                    causeMsg,
                    () -> "A record with the same unique key already exists."
                            + ex.getMessage()));

    }

}
