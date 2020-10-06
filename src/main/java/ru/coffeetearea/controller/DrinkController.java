package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.coffeetearea.dto.DrinkDTO;
import ru.coffeetearea.service.DrinkService;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static ru.coffeetearea.model.Role.ROLE_ADMIN;
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
     * Загрузить изображение для напитка
     *
     * @param drinkId
     * @param multipartFile
     * @throws IOException
     */
    @RolesAllowed({ROLE_ADMIN})
    @PostMapping(value = "/{drinkId}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadImage(@PathVariable Long drinkId, @RequestParam("file") MultipartFile multipartFile) throws IOException {

        drinkService.uploadDrinkImage(drinkId, multipartFile);
    }


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

        drinkService.takeDrinkImage(response, drinkId);
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