package ru.coffeetearea.exceptions;

public class MainNotFound extends RuntimeException {

    public MainNotFound(Long id) {
        super("Невозможно найти id: " + id);
    }

    public MainNotFound(String login) {
        super("Невозможно найти: " + login); // ИСПРАВИТЬ
    }
}