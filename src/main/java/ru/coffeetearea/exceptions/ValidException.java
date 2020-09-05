package ru.coffeetearea.exceptions;

import javax.validation.ValidationException;

public class ValidException extends ValidationException {

    public ValidException(String message){
        super(message);
    }
}
