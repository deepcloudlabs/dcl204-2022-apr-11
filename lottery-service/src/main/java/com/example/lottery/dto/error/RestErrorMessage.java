package com.example.lottery.dto.error;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class RestErrorMessage {
	private final String status;
	private final String message;

	public RestErrorMessage(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

}
