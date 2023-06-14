package com.web.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends  RuntimeException{

    private static final long serialVersionUID = 1L;
    private String resourceName;
    private String nameField;
    private long fieldValue;

    public ResourceNotFoundException(String message, String resourceName) {
        super(String.format("%s No encontrado: %s : '%s' ",message,resourceName));
        this.resourceName = resourceName;
    }
}
