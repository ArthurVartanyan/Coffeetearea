package ru.coffeetearea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffeetearea.DTO.DrinkDTO;
import ru.coffeetearea.mappers.DrinkMapper;
import ru.coffeetearea.model.Drink;
import ru.coffeetearea.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    public CustomerController(CustomerService customerService) { // DI are here
        this.customerService = customerService;
    }

    // Fields
    //
    private final CustomerService customerService;


    // Получение списка товаров
    @GetMapping("/drinks")
    List<DrinkDTO> getAllDrinks(){
        return DrinkMapper.INSTANCE.drinksToDrinksDTO(customerService.getAllDrinks());
    }
}