package ru.coffeetearea.model;

import javax.persistence.*;

/**
 * Класс: Пользователь
 * Пользователя 2 типа: Админ или Заказчик(соответствующее поле role).
 * Содержит поля: id(ИД), name(имя), lastName(фамилия), login(логин), password(пароль), mail(почта).
 */

@Entity
@Table(name = "users")
public class User {

    // Roles
    //
    public static final String ROLE_ADMIN = "ADMIN";

    public static final String ROLE_CUSTOMER = "CUSTOMER";


    // Fields
    //
    private @Id
    @GeneratedValue
    Long id;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    private String login;

    private String password;

    private String mail;

    private String role;
}