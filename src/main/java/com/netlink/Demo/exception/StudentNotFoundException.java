package com.netlink.Demo.exception;

import com.netlink.Demo.model.Student;

public class StudentNotFoundException  extends RuntimeException{
    public StudentNotFoundException(String exceptionName)
    {
        super(exceptionName);
    }
}
