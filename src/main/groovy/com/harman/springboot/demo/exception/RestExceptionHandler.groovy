package com.harman.springboot.demo.exception

import org.hibernate.exception.ConstraintViolationException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

import com.harman.springboot.demo.domain.ErrorDetails

/**
 * @author BMuthekar
 * Global REST exception Handler for application
 */
@ControllerAdvice
class RestExceptionHandler extends ResponseEntityExceptionHandler {

	RestExceptionHandler() {
		super()
	}

	@ExceptionHandler( ConstraintViolationException.class )
	ResponseEntity<ErrorDetails> handleBadRequest(final ConstraintViolationException ex, final WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
				request.getDescription(false))
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
	}

	@ExceptionHandler( DataIntegrityViolationException.class )
	ResponseEntity<ErrorDetails> handleBadRequest(final DataIntegrityViolationException ex, final WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
				request.getDescription(false))
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
	}

	@ExceptionHandler(value =  EntityNotFoundException.class )
	protected ResponseEntity<ErrorDetails> handleNotFound(final EntityNotFoundException ex, final WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
				request.getDescription(false))
		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND)
	}

	@ExceptionHandler(Exception.class)
	ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
				request.getDescription(false))
		return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR)
	}
}