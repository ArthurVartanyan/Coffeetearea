package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffeetearea.dto.DrinkDTO;
import ru.coffeetearea.service.DrinkService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/drinks")
@Api(value = "Drink", tags = {"Drink"})
public class DrinkController {

    // Fields

    private final DrinkService drinkService;


    // POST - methods

    /**
     * Добавление в избранное
     *
     * @param drinkId
     * @return
     */
    @PostMapping("/{drinkId}/favourites")
    public Long addDrinkInFavourites(@PathVariable Long drinkId) {

        return drinkService.addDrinkInFavourites(drinkId);
    }


    // GET - methods

    /**
     * Получение списка избранных напитков
     */
    @GetMapping("/favourites")
    public List<DrinkDTO> findFavouriteDrinks() {
        return drinkService.findFavouriteDrinks();
    }


    /**
     * Получение списка самых популярных товаров
     */
    @GetMapping("/populars")
    public List<DrinkDTO> findMostPopularDrinks() {

        return drinkService.findMostPopularDrinks();
    }

    /**
     * Получить изображение напитка
     *
     * @param response
     * @param drinkId
     * @throws IOException
     */
    @GetMapping("/{drinkId}/image")
    public void getDrinkImage(HttpServletResponse response, @PathVariable Long drinkId) throws IOException {
        drinkService.putDrinkImage(response, drinkId);
    }


    // Delete - methods

    /**
     * Удаление из избранных
     */
    @DeleteMapping("/{drinkId}/favourites")
    public void deleteDrinkFromFavourites(@PathVariable Long drinkId) {
        drinkService.deleteDrinkFromFavourites(drinkId);
    }
}