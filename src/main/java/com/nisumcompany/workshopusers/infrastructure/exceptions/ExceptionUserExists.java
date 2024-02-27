package com.nisumcompany.workshopusers.infrastructure.exceptions;

import lombok.Getter;

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
