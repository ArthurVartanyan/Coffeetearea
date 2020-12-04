//package ru.coffeetearea.service;
//
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import ru.coffeetearea.dto.RegistrationUserDTO;
//import ru.coffeetearea.model.Role;
//import ru.coffeetearea.model.User;
//import ru.coffeetearea.repository.UserRepository;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//class UserServiceTest {
//
//    private UserService userService;
//
//    private UserRepository userRepository;
//
//    @Autowired
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//
//    @Test
//    void registration() {
//
//        // Создаю нового регистрационного пользователя
//        RegistrationUserDTO registrationUserDTO = new RegistrationUserDTO();
//        // Ставлю ему данные
//        registrationUserDTO.setName("Arthur");
//        registrationUserDTO.setLastName("Vartanyan");
//        registrationUserDTO.setLogin("login123");
//        registrationUserDTO.setMail("arthur@mail.ru");
//        registrationUserDTO.setPassword("artur123");
//        registrationUserDTO.setCheckPassword("artur123");
//
//        // Проверяю
//        Assert.assertNotEquals("artur123", userService.findByLogin("login123").getPassword());
//        Assert.assertEquals(Role.CUSTOMER, userService.findByLogin("login123").getRole());
//    }
//
//
//    /**
//     * Удаляем пользователя после окончания теста
//     */
//    @After
//    public void deleteUser() {
//
//        User user = userRepository.getByLogin("login123");
//
//        userRepository.delete(user);
//    }
//}