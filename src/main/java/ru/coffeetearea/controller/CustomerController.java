package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffeetearea.DTO.DrinkDTO;
import ru.coffeetearea.mappers.DrinkMapper;
import ru.coffeetearea.service.UserService;

import java.util.List;

@Api(value = "Customer", tags = {"Customer"})
@RestController
@RequestMapping("/customer")
public class CustomerController {

    // Fields
    //
    private UserService userService;

    private DrinkMapper drinkMapper;


    // Dependency Injections
    //
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setDrinkMapper(DrinkMapper drinkMapper) {
        this.drinkMapper = drinkMapper;
    }
    //


    // Methods
    //
    // GET - methods
    //
    // Получение списка товаров
    @GetMapping("/drinks")
    List<DrinkDTO> getAllDrinks(){
        return drinkMapper.drinksToDrinksDTO(userService.getAllDrinks());
    }
}