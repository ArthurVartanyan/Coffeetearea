package ru.coffeetearea.model;

/**
 * Роли для пользователя:
 * Админ,
 * Заказчик.
 * Роль в БД хранится строковым типом!
 */

public enum Role {

    ADMIN, CUSTOMER;

    public static final String ROLE_CUSTOMER = "CUSTOMER";
    public static final String ROLE_ADMIN = "ADMIN";
}