package org.example.springboot.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND )
public class ResourceNotFount extends  RuntimeException{



    public ResourceNotFount(String message) {
        super(message);
    }
}
