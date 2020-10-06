package ru.coffeetearea.dto;

import lombok.Data;
import ru.coffeetearea.model.Role;

@Data
public class UserDTO {

    private Long id;

    private String name;

    private String lastName;

    private String login;

    private String mail;

    private Role role;
}