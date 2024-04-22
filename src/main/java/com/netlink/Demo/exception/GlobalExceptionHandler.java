package com.netlink.Demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<String> handleNoStudentFoundException()
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Record Found For Corresponding id");
    }
    @ExceptionHandler(value = ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException()
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot divide by zero");
    }
    @ExceptionHandler(NoPersonFoundException.class)
    public ResponseEntity<APIErrorMsg> noPersonFoundException()
    {
        APIErrorMsg apiErrorMsg = new APIErrorMsg(101,"No Record found by the given name!",new Date());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorMsg);
    }
}
