package com.insourcing.handler;

import java.sql.SQLException;

import java.time.LocalDateTime;

import javax.ws.rs.NotFoundException;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.insourcing.exception.ErrorInformation;
import com.insourcing.exception.GenericException;
import com.insourcing.message.ResponseMessage;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<ResponseMessage> handleMaxSizeException(MaxUploadSizeExceededException exc) {
	    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("File too large!"));
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorInformation> handleUserNotFoundException(Exception ex) {
		ErrorInformation errorInfo = new ErrorInformation("NOT_FOUND","Please check input parameter");
		errorInfo.setTimestamp(LocalDateTime.now());
		errorInfo.setStatus((HttpStatus.NOT_FOUND.value()));
		return new ResponseEntity<>(errorInfo ,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(GenericException.class)
	public ResponseEntity<ErrorInformation> handleUserNullPointerException(Exception ex) {
		ErrorInformation errorInfo = new ErrorInformation("INTERNAL_SERVER_ERROR","Please check input parameter");
		errorInfo.setTimestamp(LocalDateTime.now());
		errorInfo.setStatus((HttpStatus.INTERNAL_SERVER_ERROR.value()));
		return new ResponseEntity<>(errorInfo ,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({SQLException.class,DataAccessException.class})
	public ResponseEntity<ErrorInformation> handleDBException(Exception ex) {   
		ErrorInformation errorInfo = new ErrorInformation("INTERNAL_SERVER_ERROR","Database Error");
		errorInfo.setTimestamp(LocalDateTime.now());
		errorInfo.setStatus((HttpStatus.INTERNAL_SERVER_ERROR.value()));
		return new ResponseEntity<>(errorInfo ,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInformation> handleGenericException(Exception ex) {   
		ErrorInformation errorInfo = new ErrorInformation("INTERNAL_SERVER_ERROR","Please try again later");
		errorInfo.setTimestamp(LocalDateTime.now());
		errorInfo.setStatus((HttpStatus.INTERNAL_SERVER_ERROR.value()));
		return new ResponseEntity<>(errorInfo ,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
