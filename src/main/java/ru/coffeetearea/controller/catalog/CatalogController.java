package ru.coffeetearea.controller.catalog;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffeetearea.service.catalog.CatalogService;

import java.util.List;

@Api(value = "Catalog", tags = {"Catalog"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/catalog")
public class CatalogController {

    // Fields
    //
    private final CatalogService catalogService;


    // Methods
    //
    // GET - methods
    //
    // Получение списка стран
    @GetMapping("/countries")
    private List findCountries() {
        return catalogService.findCountries();
    }

    // Получение списка покетов
    @GetMapping("/packages")
    private List findPackages() {
        return catalogService.findPackages();
    }

    // Получение списка производителей
    @GetMapping("/manufacturers")
    private List findManufacturers() {
        return catalogService.findManufacturers();
    }

    // Получение списка цветов чая
    @GetMapping("/teacolors")
    private List findTeaColor() {
        return catalogService.findTeaColors();
    }

    // Получение списка типов кофе
    @GetMapping("/coffee/types")
    private List findCoffeeType() {
        return catalogService.findCoffeeTypes();
    }

    // Получение списка типов чая
    @GetMapping("/tea/types")
    private List findTeaType() {
        return catalogService.findTeaTypes();
    }

    // Получение списка прожарки
    @GetMapping("/roastings")
    private List findRoasting() {
        return catalogService.findRoastings();
    }
}