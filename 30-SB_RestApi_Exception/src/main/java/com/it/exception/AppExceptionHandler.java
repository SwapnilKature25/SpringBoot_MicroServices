package com.it.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice    // It will act as a global exception handler
public class AppExceptionHandler {
	
//	Used to handle user defined exception
	@ExceptionHandler(value=NoUserFoundException.class)
	public ResponseEntity<AppExInfo> handleUserException(NoUserFoundException e)
	{
		AppExInfo info=new AppExInfo();
		// for every type of exception one code will be available, Project management will decide the code. 
		info.setExCode("SBIEX007");    
		info.setExMsg(e.getMessage());
		info.setExDate(LocalDateTime.now());
		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
	} 
	
	
//	Used to handle pre-defined exception
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<AppExInfo> handleAppException(Exception e)
	{
		AppExInfo info=new AppExInfo();
		info.setExCode("SBIEX007");
		info.setExMsg(e.getMessage());
		info.setExDate(LocalDateTime.now());
		return new ResponseEntity<>(info, HttpStatus.INTERNAL_SERVER_ERROR);
	} 
}
