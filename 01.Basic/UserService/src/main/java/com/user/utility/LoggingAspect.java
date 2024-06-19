package com.user.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.user.exception.UserException;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    @AfterThrowing(pointcut = "execution(* com.user.service.*Impl.*(..))", throwing = "exception")
    public void logServiceException(UserException exception) throws Exception {
        logger.error(exception.getMessage(),exception);
    }
}
