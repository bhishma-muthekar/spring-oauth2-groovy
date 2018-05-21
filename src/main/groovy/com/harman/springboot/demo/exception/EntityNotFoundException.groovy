package com.harman.springboot.demo.exception

class EntityNotFoundException extends Exception{
	String errorMessage

	public String getErrorMessage() {
		return errorMessage
	}
	public EntityNotFoundException(String errorMessage) {
		super(errorMessage)
		this.errorMessage = errorMessage
	}
	public EntityNotFoundException() {
		super()
	}
}
