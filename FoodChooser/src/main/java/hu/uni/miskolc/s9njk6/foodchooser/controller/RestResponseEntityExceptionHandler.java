package hu.uni.miskolc.s9njk6.foodchooser.controller;

import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.EntityAlreadyExistsException;
import hu.uni.miskolc.s9njk6.foodchooser.service.exceptions.NoSuchEntityException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NoSuchEntityException.class)
    protected ResponseEntity<Object> handleNoSuchElement(NoSuchEntityException noSuchEntityException, WebRequest webRequest){
        return handleExceptionInternal(noSuchEntityException,noSuchEntityException.getMessage(),new HttpHeaders(), HttpStatus.NOT_FOUND,webRequest);
    }
    @ExceptionHandler(value = EntityAlreadyExistsException.class)
    protected ResponseEntity<Object> handleAlreadyExists(EntityAlreadyExistsException entityAlreadyExists, WebRequest webRequest){
        return handleExceptionInternal(entityAlreadyExists,entityAlreadyExists.getMessage(),new HttpHeaders(), HttpStatus.CONFLICT,webRequest);
    }
}
