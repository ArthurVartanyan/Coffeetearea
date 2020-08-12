package ru.coffeetearea.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Класс пользователя.
 * У пользователя есть две роли: Админ и Закзачик(см. Enum Role).
 *
 * @field is_deleted - это флаг, который говорит нам, удален пользователь или нет.
 */


@Getter
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * Имя
     */
    private String name;

    /**
     * Фамилия
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * Логин
     */
    private String login;

    /**
     * Пароль
     */
    private String password;

    /**
     * Почта
     */
    private String mail;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    /**
     * Роль (см. javadoc над классом)
     */
    @Enumerated(EnumType.STRING)
    private Role role;
}