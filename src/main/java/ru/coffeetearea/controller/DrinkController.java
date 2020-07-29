package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffeetearea.DTO.DrinkDTO;
import ru.coffeetearea.service.DrinkService;

import java.util.List;

@Api(value = "Drink", tags = {"Drink"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/drink")
public class DrinkController {

    // Fields
    //
    private final DrinkService drinkService;


    // Methods
    //
    // GET - methods
    //
    /* Получение списка товаров */
    @GetMapping("/drinks")
    List<DrinkDTO> getAllDrinks() {

        return drinkService.getAllDrinks();
    }
}