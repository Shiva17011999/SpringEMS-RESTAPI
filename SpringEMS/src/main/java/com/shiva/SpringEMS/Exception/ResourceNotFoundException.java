package com.shiva.SpringEMS.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
//@ResponseStatus annotation is used to indicate the HTTP response status code that should be sent back when a specific exception is thrown from a controller method. This annotation is typically used to customize the HTTP status codes returned in case of exceptions, providing more meaningful and appropriate responses to clients.
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
    //ResourceNotFoundException is often thrown when a client requests a resource that doesn't exist in the system, such as a record in a database or a file on a server.
    //ResourceNotFoundException extends RuntimeException, which is an unchecked exception. The class includes a constructor that takes a message parameter, allowing you to customize the error message when the exception is thrown.
}
