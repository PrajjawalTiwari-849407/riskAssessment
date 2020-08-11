package com.mfrp.risk.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
public class TokenInvalidException extends Exception {
	public TokenInvalidException(String msg) {
		super(msg);
	}
}