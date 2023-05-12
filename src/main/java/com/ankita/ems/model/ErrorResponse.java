package com.ankita.ems.model;

import java.util.Date;

/**
 * Error response model
 *
 */
public class ErrorResponse {
	private String message;
	private Date timestamp;

	public ErrorResponse() {
	}

	public ErrorResponse(String message, Date timestamp) {
		this.message = message;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return timestamp;
	}

	public void setDate(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", timestamp=" + timestamp + "]";
	}
}
