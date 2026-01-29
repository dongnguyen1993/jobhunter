package com.dong.jobhunter.service.error;


import com.dong.jobhunter.domain.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = {IdInvalidException.class})
    public ResponseEntity<Object> handleIdException(IdInvalidException idInvalidException) {
        RestResponse<Object> restResponse = new RestResponse<>();
        restResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        restResponse.setError("Exception occurs...");
        restResponse.setMessage(idInvalidException.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(restResponse);
    }
}
