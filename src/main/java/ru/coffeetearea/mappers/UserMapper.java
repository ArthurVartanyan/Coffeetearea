package ru.coffeetearea.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.coffeetearea.dto.RegistrationUserDTO;
import ru.coffeetearea.dto.UserDTO;
import ru.coffeetearea.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // UserDTO
    UserDTO userToUserDTO(User user);

    User userDTOtoUser(UserDTO userDTO);

    @IterableMapping(qualifiedByName = "userToUserDTO")
    List<UserDTO> usersToUsersDTO(List<? extends User> users);
    //

    // RegistrationUserDTO
    RegistrationUserDTO userToRegistrationUserDTO(User user);

    User registrationUserDTOtoUser(RegistrationUserDTO registrationUserDTO);

    @IterableMapping(qualifiedByName = "userToRegistrationUserDTO")
    List<RegistrationUserDTO> usersToRegistrationUsersDTO(List<? extends User> users);
    //
}