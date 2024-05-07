package br.com.fiap.tour.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHanlder {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> error404(){
        return ResponseEntity.notFound().build();
    }

}
