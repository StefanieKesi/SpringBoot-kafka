package com.stefanie.kesi.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpResult {
    private int status;
    private String msg;

    public HttpResult(int status,String msg){
        this.status = status;
        this.msg = msg;
    }
}
