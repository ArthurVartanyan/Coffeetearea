package ru.coffeetearea.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {

    // Fields
    //
    @Id
    @GeneratedValue
    private Long id;

    /** Имя */
    private String name;

    /** Фамилия */
    @Column(name = "last_name")
    private String lastName;

    /** Логин */
    private String login;

    /** Пароль */
    private String password;

    /** Почта */
    private String mail;

    /** Роль (см. javadoc над классом) */
    @Enumerated(EnumType.STRING)
    private Role role;
}