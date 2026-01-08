package com.duclm.minitaxi.exception.auth;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Invalid token")
public class InvalidTokenException {
    
}
