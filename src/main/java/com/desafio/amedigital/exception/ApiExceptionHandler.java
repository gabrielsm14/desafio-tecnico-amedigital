package com.desafio.amedigital.exception;

import com.desafio.amedigital.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity notExistId(NoSuchElementException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Id not exist", "404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }

    @ExceptionHandler(PlanetAlreadyExistsException.class)
    public ResponseEntity PlanetAlreadyExistsException(PlanetAlreadyExistsException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Planet already exists", "400");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDTO);
    }
}
