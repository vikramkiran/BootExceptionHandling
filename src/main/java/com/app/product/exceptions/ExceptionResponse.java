package com.app.product.exceptions;

import java.util.Date;

public class ExceptionResponse {

	private Date date;
	private String status;
	private String message;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [date=" + date + ", status=" + status + ", message=" + message + "]";
	}

	public ExceptionResponse(Date date, String status, String message) {
		super();
		this.date = date;
		this.status = status;
		this.message = message;
	}

	public ExceptionResponse() {
		super();
	}

}
