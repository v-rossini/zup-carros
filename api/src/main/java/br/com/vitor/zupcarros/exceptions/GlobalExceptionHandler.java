package br.com.vitor.zupcarros.exceptions;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import javax.mail.internet.AddressException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IOException.class)
	public ResponseEntity<Object> handleIOException(IOException e) {
		ApiCustomExceptionPayload apiException = new ApiCustomExceptionPayload(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
		return new ResponseEntity<> (apiException, apiException.getHttpStatus()) ;
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException e) {
		ApiCustomExceptionPayload apiException = new ApiCustomExceptionPayload(e.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now());
		return new ResponseEntity<> (apiException, apiException.getHttpStatus()) ;
	}
	
	@ExceptionHandler(AddressException.class)
	public ResponseEntity<Object> handleAddressException(AddressException e) {
		ApiCustomExceptionPayload apiException = new ApiCustomExceptionPayload(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
		return new ResponseEntity<> (apiException, apiException.getHttpStatus()) ;
	}
	
	@ExceptionHandler(ParseException.class)
	public ResponseEntity<Object> handleParseException(ParseException e) {
		ApiCustomExceptionPayload apiException = new ApiCustomExceptionPayload(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
		return new ResponseEntity<> (apiException, apiException.getHttpStatus()) ;
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
		ApiCustomExceptionPayload apiException = new ApiCustomExceptionPayload(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
		return new ResponseEntity<> (apiException, apiException.getHttpStatus()) ;
	}
	
}
