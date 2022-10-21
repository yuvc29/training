package com.fareye.training.customAnno;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice

public class Exceptionhandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handler(MethodArgumentNotValidException err){
        //return "Title already taken";
        return err.getBindingResult().getAllErrors().get(0).getDefaultMessage();
    }
}
