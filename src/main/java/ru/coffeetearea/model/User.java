package ru.coffeetearea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс пользователя.
 * У пользователя есть две роли: Админ и Закзачик(см. Enum Role).
 *
 * @field is_deleted - это флаг, который говорит нам, удален пользователь или нет.
 */


@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя
     */
    @Column(name = "name")
    private String name;

    /**
     * Фамилия
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * Логин
     */
    @Column(name = "login")
    private String login;

    /**
     * Пароль
     */
    @Column(name = "password")
    private String password;

    /**
     * Почта
     */
    @Column(name = "mail")
    private String mail;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    /**
     * Роль (см. javadoc над классом)
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "favourites",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "drink_id"))
    @JsonIgnore // Таким образом я предотвратил рекурсию
    private List<Drink> favouriteDrinks = new ArrayList<>();
}