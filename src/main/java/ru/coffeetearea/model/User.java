package ru.coffeetearea.model;

import javax.persistence.Entity;

@Entity
public class User {

    // Roles
    //
    public static final String ROLE_ADMIN = "ADMIN";

    public static final String ROLE_CUSTOMER = "CUSTOMER";



    // Fields
    //
    private Long id;

    private String name;

    private String lastName;

    private String login;

    private String password;

    private String phoneNumber;

    private String mail;

    private String role;
}