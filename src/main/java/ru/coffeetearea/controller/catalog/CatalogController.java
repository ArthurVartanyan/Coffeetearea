package ru.coffeetearea.controller.catalog;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffeetearea.dto.GeneralCatalogDTO;
import ru.coffeetearea.service.catalog.CatalogService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalogs")
@Api(value = "Catalog", tags = {"Catalog"})
public class CatalogController {

    // Fields

    final CatalogService catalogService;


    // POST - methods

    @PostMapping("/coffee")
    public GeneralCatalogDTO addCoffeeType(@RequestParam String name) {

        return catalogService.addCoffeeType(name);
    }

    @PostMapping("/countries")
    public GeneralCatalogDTO addCountry(@RequestParam String name) {

        return catalogService.addCountry(name);
    }

    @PostMapping("/manufacturers")
    public GeneralCatalogDTO addManufacturer(@RequestParam String name) {

        return catalogService.addManufacturer(name);
    }

    @PostMapping("/packages")
    public GeneralCatalogDTO addPackaging(@RequestParam String name) {

        return catalogService.addPackaging(name);
    }

    @PostMapping("/roastings")
    public GeneralCatalogDTO addRoasting(@RequestParam String name) {

        return catalogService.addRoasting(name);
    }

    @PostMapping("/tea-colors")
    public GeneralCatalogDTO addTeaColor(@RequestParam String name) {

        return catalogService.addTeaColor(name);
    }

    @PostMapping("/tea-types")
    public GeneralCatalogDTO addTeaType(@RequestParam String name) {

        return catalogService.addTeaType(name);
    }


    // GET - methods

    /**
     * Получение списка стран
     *
     * @return List<GeneralCatalogDTO>
     */
    @GetMapping("/countries")
    public List<GeneralCatalogDTO> findCountries() {
        return catalogService.findCountries();
    }

    /**
     * Получение списка пакетов
     *
     * @return List<GeneralCatalogDTO>
     */
    @GetMapping("/packages")
    public List<GeneralCatalogDTO> findPackages() {
        return catalogService.findPackages();
    }

    /**
     * Получение списка производителей
     *
     * @return List<GeneralCatalogDTO>
     */
    @GetMapping("/manufacturers")
    public List<GeneralCatalogDTO> findManufacturers() {
        return catalogService.findManufacturers();
    }

    /**
     * Получение списка цветов чая
     *
     * @return List<GeneralCatalogDTO>
     */
    @GetMapping("/tea-colors")
    public List<GeneralCatalogDTO> findTeaColor() {
        return catalogService.findTeaColors();
    }

    /**
     * Получение списка типов кофе
     *
     * @return List<GeneralCatalogDTO>
     */
    @GetMapping("/coffee-types")
    public List<GeneralCatalogDTO> findCoffeeType() {
        return catalogService.findCoffeeTypes();
    }

    /**
     * Получение списка типов чая
     *
     * @return List<GeneralCatalogDTO>
     */
    @GetMapping("/tea-types")
    public List<GeneralCatalogDTO> findTeaType() {
        return catalogService.findTeaTypes();
    }

    /**
     * Получение списка типов прожарки
     *
     * @return List<GeneralCatalogDTO>
     */
    @GetMapping("/roastings")
    public List<GeneralCatalogDTO> findRoasting() {
        return catalogService.findRoastings();
    }


    // PUT - methods

    /**
     * Редактирование элементов типов кофе
     */
    @PutMapping("/{coffeeTypeId}/coffee-types")
    public GeneralCatalogDTO editCoffeeType(@PathVariable Long coffeeTypeId, @RequestParam String name) {

        return catalogService.editCoffeeType(coffeeTypeId, name);
    }

    /**
     * Редактирование элементов стран
     */
    @PutMapping("/{countryId}/countries")
    public GeneralCatalogDTO editCountry(@PathVariable Long countryId, @RequestParam String name) {

        return catalogService.editCountry(countryId, name);
    }


    /**
     * Редактирование элементов типов производителей
     */
    @PutMapping("/{manufacturerId}/manufacturers")
    public GeneralCatalogDTO editManufacturer(@PathVariable Long manufacturerId, @RequestParam String name) {

        return catalogService.editManufacturer(manufacturerId, name);
    }


    /**
     * Редактирование элементов типов пакетов
     */
    @PutMapping("/{packagingId}/packages")
    public GeneralCatalogDTO editPackaging(@PathVariable Long packagingId, @RequestParam String name) {

        return catalogService.editPackaging(packagingId, name);
    }


    /**
     * Редактирование элементов типов обжарки
     */
    @PutMapping("/{roastingId}/roastings")
    public GeneralCatalogDTO editRoasting(@PathVariable Long roastingId, @RequestParam String name) {

        return catalogService.editRoasting(roastingId, name);
    }


    /**
     * Редактирование элементов цветов чая
     */
    @PutMapping("/{teaColorId}/tea-colors")
    public GeneralCatalogDTO editTeaColor(@PathVariable Long teaColorId, @RequestParam String name) {

        return catalogService.editTeaColor(teaColorId, name);
    }

    /**
     * Редактирование элементов типов чая
     */
    @PutMapping("/{teaTypeId}/tea-types")
    public GeneralCatalogDTO editTeaType(@PathVariable Long teaTypeId, @RequestParam String name) {

        return catalogService.editTeaType(teaTypeId, name);
    }


    /**
     * Удаление элементов типов кофе
     */
    @PutMapping("/{coffeeTypeId}/delete/coffee-type")
    public void deleteCoffeeType(@PathVariable Long coffeeTypeId) {
        catalogService.deleteCoffeeType(coffeeTypeId);
    }

    /**
     * Удаление элементов стран
     */
    @PutMapping("/{countryId}/delete/countrie")
    public void deleteCountry(@PathVariable Long countryId) {
        catalogService.deleteCountry(countryId);
    }

    /**
     * Удаление элементов произваодителей
     */
    @PutMapping("/{manufacturerId}/delete/manufacturer")
    public void deleteManufacturer(@PathVariable Long manufacturerId) {
        catalogService.deleteManufacturer(manufacturerId);
    }

    /**
     * Удаление элементов упаковок
     */
    @PutMapping("/{packagingId}/delete/package")
    public void deletePackaging(@PathVariable Long packagingId) {
        catalogService.deletePackaging(packagingId);
    }

    /**
     * Удаление элементов обжарки кофе
     */
    @PutMapping("/{roastingId}/delete/roasting")
    public void deleteRoasting(@PathVariable Long roastingId) {
        catalogService.deleteRoasting(roastingId);
    }

    /**
     * Удаление элементов цвета чая
     */
    @PutMapping("/{teaColorId}/delete/tea-color")
    public void deleteTeaColor(@PathVariable Long teaColorId) {
        catalogService.deleteTeaColor(teaColorId);
    }

    /**
     * Удаление элементов типа чая
     */
    @PutMapping("/{teaTypeId}/delete/tea-type")
    public void deleteTeaType(@PathVariable Long teaTypeId) {
        catalogService.deleteTeaType(teaTypeId);
    }
}