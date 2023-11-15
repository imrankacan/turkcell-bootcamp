package com.turkcell.spring.starter;

import com.turkcell.spring.starter.business.exceptions.BusinessException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestControllerAdvice
public class Application {

	public static void main(String[] args) {SpringApplication.run(Application.class, args);
	}
	// Global Exception Handling

	//Uygulamanın neresinden olursa olsun runtime exceptionları yakalamak için kullandığımız yöntem
	@ExceptionHandler({MethodArgumentNotValidException.class})
	public List<String> handleValidationException(MethodArgumentNotValidException ex){
		List<String>errors = new ArrayList<>();
		ex.getBindingResult().getAllErrors().forEach((objectError) -> {
			String fieldName = ((FieldError)objectError).getField();
			String errorMessage = objectError.getDefaultMessage();

			String message = fieldName + ":"+ errorMessage;
			errors.add(message);
		});
		return errors;

	}
	@ExceptionHandler({BusinessException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleBusinessException(BusinessException ex){
		return ex.getMessage();

	}

}
