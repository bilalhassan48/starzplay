package com.starzplay.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Bilal Hassan on 18-Sep-22
 * @project starzplay
 */

@Slf4j
@RestControllerAdvice
public class CustomException {

    /**
     * We can have more exception handler methods for specific exceptions and currently I'm returning
     * exception as string we can make our custom Response object for proper json response!!
     */
    @ExceptionHandler(Exception.class)
    public String exception(final Exception e) {
        log.error(e.getLocalizedMessage());
        return e.getMessage();
    }
}
