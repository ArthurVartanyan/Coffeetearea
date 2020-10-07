package ru.coffeetearea.model;

/**
 * У пользователя есть своя роль, наприер: Администратор или Заказчик.
 * Роль в БД хранится строковым типом!
 */

public enum Role {

    /**
     * Эти enum-ы нужны для работы непосредственно в коде.
     */
    ADMIN, CUSTOMER;

    /**
     * Эти строковые статичные константы нужны для @RolesAllowed(Spring Security)
     */
    public static final String ROLE_CUSTOMER = "CUSTOMER";

    public static final String ROLE_ADMIN = "ADMIN";
}