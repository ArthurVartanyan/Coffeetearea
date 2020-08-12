package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.coffeetearea.dto.DrinkDTO;
import ru.coffeetearea.dto.PageDTO;
import ru.coffeetearea.service.DrinkService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/drink")
@Api(value = "Drink", tags = {"Drink"})
public class DrinkController {

    // Fields
    //
    private final DrinkService drinkService;


    // Methods
    //
    // GET - methods
    //

    /**
     * Получение списка товаров
     */
    @GetMapping("/drinks")
    private PageDTO<DrinkDTO> getAllDrinks(@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "page_size", defaultValue = "2") int pageSize) {

        return drinkService.findAllDrinks(page, pageSize);
    }
}