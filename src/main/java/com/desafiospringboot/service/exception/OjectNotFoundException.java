package com.desafiospringboot.service.exception;

public class OjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public OjectNotFoundException(String msg) {
		super(msg);
	}

	public OjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
