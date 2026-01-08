package com.duclm.minitaxi.exception;

public class BaseException extends RuntimeException  {
    private final int status;
    private final String code;

    protected BaseException(int status, String code, String message) {
        super(message);
        this.status = status;
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }
    
}
