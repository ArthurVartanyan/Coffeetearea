package ru.coffeetearea.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {

    // Roles
    //
    /* Роль Админа */
    public static final String ROLE_ADMIN = "ADMIN";

    /* Роль Заказчика */
    public static final String ROLE_CUSTOMER = "CUSTOMER";


    // Fields
    //
    private @Id
    @GeneratedValue
    Long id;

    /* мя */
    private String name;

    /* Фамилия */
    @Column(name = "last_name")
    private String lastName;

    /* Логин */
    private String login;

    /* Пароль */
    private String password;

    /* Почта */
    private String mail;

    /* Роль (см. javadoc над классом) */
    private String role;
}