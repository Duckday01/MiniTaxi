package com.duclm.minitaxi.exception.auth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Unauthorized access")
public class UnauthorizedException {
    private static final long serialVersionUID = 3996139622151563508L;

}
