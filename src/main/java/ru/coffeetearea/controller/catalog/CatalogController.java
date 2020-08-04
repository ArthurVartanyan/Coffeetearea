package ru.coffeetearea.controller.catalog;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffeetearea.dto.GeneralCatalogDTO;
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
    private List<GeneralCatalogDTO> findCountries() {
        return catalogService.findCountries();
    }

    // Получение списка покетов
    @GetMapping("/packages")
    private List<GeneralCatalogDTO> findPackages() {
        return catalogService.findPackages();
    }

    // Получение списка производителей
    @GetMapping("/manufacturers")
    private List<GeneralCatalogDTO> findManufacturers() {
        return catalogService.findManufacturers();
    }

    // Получение списка цветов чая
    @GetMapping("/tea-colors")
    private List<GeneralCatalogDTO> findTeaColor() {
        return catalogService.findTeaColors();
    }

    // Получение списка типов кофе
    @GetMapping("/coffee-types")
    private List<GeneralCatalogDTO> findCoffeeType() {
        return catalogService.findCoffeeTypes();
    }

    // Получение списка типов чая
    @GetMapping("/tea-types")
    private List<GeneralCatalogDTO> findTeaType() {
        return catalogService.findTeaTypes();
    }

    // Получение списка прожарки
    @GetMapping("/roastings")
    private List<GeneralCatalogDTO> findRoasting() {
        return catalogService.findRoastings();
    }
}