package ru.coffeetearea.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id) {
        super("Внимание! Невозможно найти id: " + id);
    }

    public EntityNotFoundException(String login) {
        super("Внимание! Невозможно найти login: " + login);
    }
}