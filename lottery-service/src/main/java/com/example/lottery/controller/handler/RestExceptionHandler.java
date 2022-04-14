package com.example.lottery.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.lottery.dto.error.RestErrorMessage;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public RestErrorMessage handleIllegalArgumentException(IllegalArgumentException e) {
		return new RestErrorMessage("failure", e.getMessage());
	}
}
