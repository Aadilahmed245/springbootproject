package com.netlink.Demo.exception;

public class NoPersonFoundException extends RuntimeException{
    public NoPersonFoundException(String exceptionName)
    {
        super("No Person Found By This Name!");
    }
}
