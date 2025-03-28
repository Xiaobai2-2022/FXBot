package com.fangxia.fxbot.aop;

import com.fangxia.fxbot.annotations.FXValidateKey;
import com.fangxia.fxbot.common.FXApiResponse;
import com.fangxia.fxbot.security.FXSecurityKey;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@RequiredArgsConstructor
public class FXValidateKeyAOP {

    private final FXSecurityKey fxSecurityKey;

    @Around("@annotation(fxValidateKey)")
    public Object verifyServerKey(ProceedingJoinPoint joinPoint, FXValidateKey fxValidateKey) throws Throwable {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (attrs == null) {
            return FXApiResponse.failure("No request context found.");
        }

        HttpServletRequest request = attrs.getRequest();
        String serverKey = request.getHeader("serverKey");

        FXApiResponse<?> result = fxSecurityKey.validate(serverKey);
        if (!result.isSuccess()) {
            return result;
        }

        return joinPoint.proceed();
    }

}
