package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.coffeetearea.dto.DrinkDTO;
import ru.coffeetearea.service.DrinkService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/drinks")
@Api(value = "Drink", tags = {"Drink"})
public class DrinkController {

    // Fields

    private final DrinkService drinkService;


    @GetMapping("/image")
    public void getImageAsByteArray(HttpServletRequest request, HttpServletResponse response) throws IOException {
        InputStream in = new FileInputStream("C:\\Users\\vartanyan\\Desktop\\images\\Puer.jpg");
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }

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


    // Delete - methods

    /**
     * Удаление из избранных
     */
    @DeleteMapping("/{drinkId}/favourites")
    public void deleteDrinkFromFavourites(@PathVariable Long drinkId) {
        drinkService.deleteDrinkFromFavourites(drinkId);
    }
}