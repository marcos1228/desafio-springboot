package com.desafiospringboot.controller.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> Errors = new ArrayList<>();

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);

	}

	public List<FieldMessage> getErrors() {
		return Errors;
	}

	public void addError(String fieldName, String messagem) {
		Errors.add(new FieldMessage(fieldName, messagem));
	}

}
