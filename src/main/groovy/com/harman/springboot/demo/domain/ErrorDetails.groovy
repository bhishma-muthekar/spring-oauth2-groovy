package com.harman.springboot.demo.domain

class ErrorDetails {
	Date timestamp
	String message
	String details

	public ErrorDetails(Date timestamp, String message, String details) {
		super()
		this.timestamp = timestamp
		this.message = message
		this.details = details
	}
}
