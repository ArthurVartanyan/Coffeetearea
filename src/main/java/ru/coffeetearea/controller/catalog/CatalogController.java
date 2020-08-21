package ru.coffeetearea.controller.catalog;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffeetearea.dto.GeneralCatalogDTO;
import ru.coffeetearea.model.catalog.*;
import ru.coffeetearea.service.catalog.CatalogService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalog")
@Api(value = "Catalog", tags = {"Catalog"})
public class CatalogController {

    // Fields

    final CatalogService catalogService;


    // POST - methods

    @PostMapping("/coffee-type-add")
    public GeneralCatalogDTO addCoffeeType(String name) {

        return catalogService.addCoffeeType(name);
    }

    @PostMapping("/country-add")
    public GeneralCatalogDTO addCountry(String name) {

        return catalogService.addCountry(name);
    }

    @PostMapping("/manufacturer-add")
    public GeneralCatalogDTO addManufacturer(String name) {

        return catalogService.addManufacturer(name);
    }

    @PostMapping("/packaging-add")
    public GeneralCatalogDTO addPackaging(String name) {

        return catalogService.addPackaging(name);
    }

    @PostMapping("/roasting-add")
    public GeneralCatalogDTO addRoasting(String name) {

        return catalogService.addRoasting(name);
    }

    @PostMapping("/tea-color-add")
    public GeneralCatalogDTO addTeaColor(String name) {

        return catalogService.addTeaColor(name);
    }

    @PostMapping("/tea-type-add")
    public GeneralCatalogDTO addTeaType(String name) {

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
    @PutMapping("/{coffeeTypeId}/coffee-type-edit")
    public GeneralCatalogDTO editCoffeeType(@PathVariable Long coffeeTypeId, String name) {

        return catalogService.editCoffeeType(coffeeTypeId, name);
    }

    /**
     * Редактирование элементов стран
     */
    @PutMapping("/{countryId}/country-edit")
    public GeneralCatalogDTO editCountry(@PathVariable Long countryId, String name) {

        return catalogService.editCountry(countryId, name);
    }


    /**
     * Редактирование элементов типов производителей
     */
    @PutMapping("/{manufacturerId}/manufacturer-edit")
    public GeneralCatalogDTO editManufacturer(@PathVariable Long manufacturerId, String name) {

        return catalogService.editManufacturer(manufacturerId, name);
    }


    /**
     * Редактирование элементов типов пакетов
     */
    @PutMapping("/{packagingId}/packaging-edit")
    public GeneralCatalogDTO editPackaging(@PathVariable Long packagingId, String name) {

        return catalogService.editPackaging(packagingId, name);
    }


    /**
     * Редактирование элементов типов обжарки
     */
    @PutMapping("/{roastingId}/roasting-edit")
    public GeneralCatalogDTO editRoasting(@PathVariable Long roastingId, String name) {

        return catalogService.editRoasting(roastingId, name);
    }


    /**
     * Редактирование элементов цветов чая
     */
    @PutMapping("/{teaColorId}/tea-color-edit")
    public GeneralCatalogDTO editTeaColor(@PathVariable Long teaColorId, String name) {

        return catalogService.editTeaColor(teaColorId, name);
    }

    /**
     * Редактирование элементов типов чая
     */
    @PutMapping("/{teaTypeId}/tea-type-edit")
    public GeneralCatalogDTO editTeaType(@PathVariable Long teaTypeId, String name) {

        return catalogService.editTeaType(teaTypeId, name);
    }


    /**
     * Удаление элементов типов кофе
     */
    @PutMapping("/{coffeeTypeId}/coffee-type-delete")
    public void deleteCoffeeType(@PathVariable Long coffeeTypeId) {
        catalogService.deleteCoffeeType(coffeeTypeId);
    }

    /**
     * Удаление элементов стран
     */
    @PutMapping("/{countryId}/country-delete")
    public void deleteCountry(@PathVariable Long countryId) {
        catalogService.deleteCountry(countryId);
    }

    /**
     * Удаление элементов произваодителей
     */
    @PutMapping("/{manufacturerId}/manufacturer-delete")
    public void deleteManufacturer(@PathVariable Long manufacturerId) {
        catalogService.deleteManufacturer(manufacturerId);
    }

    /**
     * Удаление элементов упаковок
     */
    @PutMapping("/{packagingId}/packaging-delete")
    public void deletePackaging(@PathVariable Long packagingId) {
        catalogService.deletePackaging(packagingId);
    }

    /**
     * Удаление элементов обжарки кофе
     */
    @PutMapping("/{roastingId}/roasting-delete")
    public void deleteRoasting(@PathVariable Long roastingId) {
        catalogService.deleteRoasting(roastingId);
    }

    /**
     * Удаление элементов цвета чая
     */
    @PutMapping("/{teaColorId}/tea-color-delete")
    public void deleteTeaColor(@PathVariable Long teaColorId) {
        catalogService.deleteTeaColor(teaColorId);
    }

    /**
     * Удаление элементов типа чая
     */
    @PutMapping("/{teaTypeId}/tea-type-delete")
    public void deleteTeaType(@PathVariable Long teaTypeId) {
        catalogService.deleteTeaType(teaTypeId);
    }
}