package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffeetearea.DTO.DrinkDTO;
import ru.coffeetearea.mappers.DrinkMapper;
import ru.coffeetearea.model.Drink;
import ru.coffeetearea.service.DrinkService;

import java.awt.print.Pageable;
import java.util.List;

@Api(value = "Drink", tags = {"Drink"})
@RestController
@RequestMapping("/drink")
public class DrinkController {

    // Fields
    //
    private DrinkService drinkService;

    private DrinkMapper drinkMapper;


    // Dependency Injections
    //
    @Autowired
    public void setUserService(DrinkService drinkService) {
        this.drinkService = drinkService;
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
        return drinkMapper.drinksToDrinksDTO(drinkService.getAllDrinks());
    }
}