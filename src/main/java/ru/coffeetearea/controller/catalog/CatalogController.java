package ru.coffeetearea.controller.catalog;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffeetearea.dto.GeneralCatalogDTO;
import ru.coffeetearea.service.catalog.CatalogService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalog")
@Api(value = "Catalog", tags = {"Catalog"})
public class CatalogController {

    // Fields
    //
    private final CatalogService catalogService;



    // GET - methods
    //

    /**
     * Получение списка стран
     *
     * @return List<GeneralCatalogDTO>
     */
    @GetMapping("/countries")
    private List<GeneralCatalogDTO> findCountries() {
        return catalogService.findCountries();
    }

    /**
     * Получение списка пакетов
     *
     * @return List<GeneralCatalogDTO>
     */
    @GetMapping("/packages")
    private List<GeneralCatalogDTO> findPackages() {
        return catalogService.findPackages();
    }

    /**
     * Получение списка производителей
     *
     * @return List<GeneralCatalogDTO>
     */
    @GetMapping("/manufacturers")
    private List<GeneralCatalogDTO> findManufacturers() {
        return catalogService.findManufacturers();
    }

    /**
     * Получение списка цветов чая
     *
     * @return List<GeneralCatalogDTO>
     */
    @GetMapping("/tea-colors")
    private List<GeneralCatalogDTO> findTeaColor() {
        return catalogService.findTeaColors();
    }

    /**
     * Получение списка типов кофе
     *
     * @return List<GeneralCatalogDTO>
     */
    @GetMapping("/coffee-types")
    private List<GeneralCatalogDTO> findCoffeeType() {
        return catalogService.findCoffeeTypes();
    }

    /**
     * Получение списка типов чая
     *
     * @return List<GeneralCatalogDTO>
     */
    @GetMapping("/tea-types")
    private List<GeneralCatalogDTO> findTeaType() {
        return catalogService.findTeaTypes();
    }

    /**
     * Получение списка типов прожарки
     *
     * @return List<GeneralCatalogDTO>
     */
    @GetMapping("/roastings")
    private List<GeneralCatalogDTO> findRoasting() {
        return catalogService.findRoastings();
    }
}