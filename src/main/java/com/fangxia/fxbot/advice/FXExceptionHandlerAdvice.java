package com.fangxia.fxbot.advice;
import com.fangxia.fxbot.common.FXApiResponse;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.management.ReflectionException;
import java.sql.SQLSyntaxErrorException;
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
                () -> "A record with the same unique key already exists." +
                ex.getMessage()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public FXApiResponse<?> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {

        Throwable cause = ex.getMostSpecificCause();
        String causeMsg = cause.getMessage();
        return FXApiResponse.failure(
            Objects.requireNonNullElseGet(
                causeMsg,
                () -> "A SQL Syntax Error has occurred:" +
                ex.getMessage()));
    }

    @ExceptionHandler(SQLSyntaxErrorException.class)
    public FXApiResponse<?> handleSQLSyntaxErrorException(SQLSyntaxErrorException ex) {
        return FXApiResponse.failure(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public FXApiResponse<?> handleAnyException(ReflectionException ex) {
        return FXApiResponse.failure(ex.getMessage());
    }

}
