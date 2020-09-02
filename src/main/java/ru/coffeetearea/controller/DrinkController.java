package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import ru.coffeetearea.dto.DrinkDTO;
import ru.coffeetearea.service.DrinkService;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;


@RestController
@RequiredArgsConstructor
@RequestMapping("/drinks")
@Api(value = "Drink", tags = {"Drink"})
public class DrinkController {

    // Fields

    private final DrinkService drinkService;

    @GetMapping(value = "/image")
    public @ResponseBody Image getImageAsByteArray() throws IOException {
        InputStream in = new BufferedInputStream(
                new FileInputStream("C:\\Users\\Артур\\Desktop\\images\\Puer.jpg"));
        Image image = ImageIO.read(in);
//                ApplicationContext.class.getResourceAsStream("C:\\Users\\Артур\\Desktop\\images");
        return image;
    }


//    @GetMapping("/image")
//    public void getImageAsByteArray(HttpServletResponse response) throws IOException {
//
//        ImageInputStream in = Files.readAllBytes("C:\\Users\\Артур\Desktop\\images");
//        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//        IOUtils.copy(in, response.getOutputStream());
//    }

//    public Properties getImage() throws IOException {
//
//        Properties properties = new Properties();
//
//        File file = ResourceUtils.getFile("classpath:application.properties");
//        InputStream in = new FileInputStream(file);
//        properties.load(in);
//
//        return properties;
//    }


//    @GetMapping("/image")
//    public @ResponseBody byte[]getImageAsByteArray() throws IOException {
//        BufferedImage in = ImageIO.read(new File("/WEB-INF/images/image-example.jpg"));
//        return IOUtils.toByteArray(in);
//    }


    // POST - methods

    /**
     * Добавление в избранное
     *
     * @param drinkId
     * @return
     */
    @PostMapping("/{drinkId}/favourites")
    public DrinkDTO addDrinkInFavourites(@PathVariable Long drinkId) {

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