package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffeetearea.dto.DrinkDTO;
import ru.coffeetearea.service.DrinkService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/drink")
@Api(value = "Drink", tags = {"Drink"})
public class DrinkController {

    // Fields

    private final DrinkService drinkService;


    // POST - methods

    /**
     * Добавление в избранное
     * @param drinkId
     * @return
     */
    @PostMapping("/{drinkId}/add-favourites/")
    public DrinkDTO addDrinkInFavourites(@PathVariable Long drinkId) {

        return drinkService.addDrinkInFavourites(drinkId);
    }


    // GET - methods

    /**
     * Получение списка избранных напитков
     */
    @GetMapping("/drinks-favourite")
    public List<DrinkDTO> findFavouriteDrinks() {
        return drinkService.findFavouriteDrinks();
    }


    /**
     * Получение списка товаров
     */
//    @GetMapping("/drinks")
//    public PageDTO<DrinkDTO> getAllDrinks(@RequestParam(value = "page", defaultValue = "0") int page,
//                                           @RequestParam(value = "page_size", defaultValue = "2") int pageSize) {
//
//        return drinkService.findAllDrinks(page, pageSize);
//    }


    // Delete - methods

    /**
     * Удаление из избранных
     */
    @DeleteMapping("/{drinkId}/favourite-delete")
    public void deleteDrinkFromFavourites(@PathVariable Long drinkId) {
        drinkService.deleteDrinkFromFavourites(drinkId);
    }
}