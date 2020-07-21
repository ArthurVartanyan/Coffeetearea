package ru.coffeetearea.model;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "public")
public class User {

    public User() { // Constructor for Hibernate

    }

    // Roles
    //
    public static final String ROLE_ADMIN = "ADMIN";

    public static final String ROLE_CUSTOMER = "CUSTOMER";


    // Fields
    //
    private @Id
    @GeneratedValue
    Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "mail")
    private String mail;

    @Column(name = "role")
    private String role;
}