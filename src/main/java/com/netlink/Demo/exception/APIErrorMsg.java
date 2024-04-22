package com.netlink.Demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class APIErrorMsg {
    private int errorCode;
    private String errorDesc;
    private Date date;
}
