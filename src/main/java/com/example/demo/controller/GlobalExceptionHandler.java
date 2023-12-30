package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String>handlerExcetion (Exception ex){
        logger.error("Se produjo un error no controlado a nivel del servidor", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno de servidor");
    }
}
