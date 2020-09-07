package ru.coffeetearea.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    private String name;

    private String lastName;

    private String login;

    private String mail;
}