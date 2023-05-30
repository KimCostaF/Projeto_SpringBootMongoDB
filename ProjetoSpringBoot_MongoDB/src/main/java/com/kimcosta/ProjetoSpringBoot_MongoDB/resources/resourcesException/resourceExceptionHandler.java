package com.kimcosta.ProjetoSpringBoot_MongoDB.resources.resourcesException;

import com.kimcosta.ProjetoSpringBoot_MongoDB.services.servicesException.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class resourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
   public ResponseEntity<StandardError> objectnorfound(ObjectNotFoundException e, HttpServletRequest request){
       HttpStatus status = HttpStatus.NOT_FOUND;
       StandardError er = new StandardError(System.currentTimeMillis(), status.value(),"Não encontrado",e.getMessage(),request.getRequestURI());

       return ResponseEntity.status(status).body(er);

   }
}
