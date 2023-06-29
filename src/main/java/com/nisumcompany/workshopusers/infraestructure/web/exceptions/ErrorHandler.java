package com.nisumcompany.workshopusers.infraestructure.web.exceptions;

import com.nisumcompany.workshopusers.dto.ErrorResponse;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ErrorHandler  extends ResponseEntityExceptionHandler {
  private void printErrorRequest(HttpServletRequest req) {
    log.error("Request: " + req.getRequestURL());
  }

  @ExceptionHandler(ExceptionUserExists.class)
  public ResponseEntity<ErrorResponse> methodEmailExistsException(HttpServletRequest request, ExceptionUserExists e) {
    this.printErrorRequest(request);
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setMessage(e.getMessage());

    return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);

  }

  @ExceptionHandler(ExceptionRequestInvalid.class)
  public ResponseEntity<ErrorResponse> methodEmailNotValidException(HttpServletRequest request, ExceptionRequestInvalid e){
    this.printErrorRequest(request);
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setMessage(e.getMessage());

    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }

}
