package ru.coffeetearea.controller.catalog;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.coffeetearea.DTO.PageDTO.PageDTO;
import ru.coffeetearea.DTO.catalogDTO.GeneralCatalogDTO;
import ru.coffeetearea.service.catalog.CatalogService;

@Api(value = "Catalog", tags = {"Catalog"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/catalog")
public class CatalogController {

    // Fields
    //
    private final CatalogService catalogService;


    // GET - methods
    //
    //

    /**
     * Получение списка стран
     *
     * @param page
     * @param pageSize
     */
    @GetMapping("/countries")
    private PageDTO<? extends GeneralCatalogDTO> findCountries(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "page_size", defaultValue = "6") int pageSize) {

        return catalogService.findCountries(page, pageSize);
    }

    /**
     * Получение списка покетов
     *
     * @param page
     * @param pageSize
     */
    @GetMapping("/packages")
    private PageDTO<? extends GeneralCatalogDTO> findPackages(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "page_size", defaultValue = "6") int pageSize) {

        return catalogService.findPackages(page, pageSize);
    }

    /**
     * Получение списка производителей
     *
     * @param page
     * @param pageSize
     */
    @GetMapping("/manufacturers")
    private PageDTO<? extends GeneralCatalogDTO> findManufacturers(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "page_size", defaultValue = "6") int pageSize) {

        return catalogService.findManufacturers(page, pageSize);
    }

    /**
     * Получение списка цветов чая
     *
     * @param page
     * @param pageSize
     */
    @GetMapping("/teacolors")
    private PageDTO<? extends GeneralCatalogDTO> findTeaColors(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "page_size", defaultValue = "6") int pageSize) {

        return catalogService.findTeaColors(page, pageSize);
    }

    /**
     * Получение списка типов кофе
     *
     * @param page
     * @param pageSize
     */
    @GetMapping("/coffeetypes")
    private PageDTO<? extends GeneralCatalogDTO> findCoffeeTypes(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "page_size", defaultValue = "6") int pageSize) {

        return catalogService.findCoffeeTypes(page, pageSize);
    }

    /**
     * Получение списка типов чая
     *
     * @param page
     * @param pageSize
     */
    @GetMapping("/teatypes")
    private PageDTO<? extends GeneralCatalogDTO> findTeaTypes(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "page_size", defaultValue = "6") int pageSize) {

        return catalogService.findTeaTypes(page, pageSize);
    }

    /**
     * Получение списка прожарки
     *
     * @param page
     * @param pageSize
     */
    @GetMapping("/roastings")
    private PageDTO<? extends GeneralCatalogDTO> findRoastings(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "page_size", defaultValue = "6") int pageSize) {

        return catalogService.findRoastings(page, pageSize);
    }
}