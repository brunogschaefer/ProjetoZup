package com.zup.projetoLoteria.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason="E-mail already exists/E-mail já existe")
public class AlreadyExistsException extends Exception{
	private static final long serialVersionUID = 1L;
}
