package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.*;
import ru.coffeetearea.dto.DrinkDTO;
import ru.coffeetearea.service.DrinkService;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static ru.coffeetearea.model.Role.ROLE_CUSTOMER;


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
     */
    @RolesAllowed({ROLE_CUSTOMER})
    @PostMapping("/{drinkId}/favourites")
    public Long addDrinkInFavourites(@PathVariable Long drinkId) {

        return drinkService.addDrinkInFavourites(drinkId);
    }


    // GET - methods


    /**
     * Получение списка избранных напитков
     */
    @RolesAllowed({ROLE_CUSTOMER})
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
    @RolesAllowed({ROLE_CUSTOMER})
    @DeleteMapping("/{drinkId}/favourites")
    public void deleteDrinkFromFavourites(@PathVariable Long drinkId) {

        drinkService.deleteDrinkFromFavourites(drinkId);
    }
}