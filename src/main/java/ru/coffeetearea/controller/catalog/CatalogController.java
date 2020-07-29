package ru.coffeetearea.controller.catalog;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffeetearea.model.catalog.*;
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
    private List<Countries> findCountries() {
        return catalogService.findCountries();
    }

    // Получение списка покетов
    @GetMapping("/packages")
    private List<Packaging> findPackages() {
        return catalogService.findPackagings();
    }

    // Получение списка производителей
    @GetMapping("/manufacturers")
    private List<Manufacturer> findManufacturers() {
        return catalogService.findManufacturers();
    }

    // Получение списка цветов чая
    @GetMapping("/teacolors")
    private List<TeaColor> findTeaColor() {
        return catalogService.findTeaColors();
    }

    // Получение списка типов кофе
    @GetMapping("/coffeetypes")
    private List<CoffeeType> findCoffeeType() {
        return catalogService.findCoffeeTypes();
    }

    // Получение списка типов чая
    @GetMapping("/teatypes")
    private List<TeaType> findTeaType() {
        return catalogService.findTeaTypes();
    }

    // Получение списка прожарки
    @GetMapping("/roastings")
    private List<Roasting> findRoasting() {
        return catalogService.findRoastings();
    }
}