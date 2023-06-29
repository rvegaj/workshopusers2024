package com.nisumcompany.workshopusers.infraestructure.web.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
public class ExceptionUserExists extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String message;

    public ExceptionUserExists(String exception){
      super(exception);
      this.message = exception;
    }

}
