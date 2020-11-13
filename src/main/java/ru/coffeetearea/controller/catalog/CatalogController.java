package ru.coffeetearea.controller.catalog;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.coffeetearea.dto.GeneralCatalogDTO;
import ru.coffeetearea.service.catalog.CatalogService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

import static ru.coffeetearea.model.Role.ROLE_ADMIN;
import static ru.coffeetearea.model.Role.ROLE_CUSTOMER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/catalogs")
@Api(value = "Catalog", tags = {"Catalog"})
public class CatalogController {

    // Fields

    final CatalogService catalogService;


    // POST - methods

    @RolesAllowed({ROLE_ADMIN})
    @PostMapping("/coffee-types")
    public ResponseEntity<GeneralCatalogDTO> addCoffeeType(@Validated(GeneralCatalogDTO.New.class)
                                                           @RequestBody GeneralCatalogDTO generalCatalogDTO) {

        return new ResponseEntity<>(catalogService
                .addCoffeeType(generalCatalogDTO.getName()), HttpStatus.OK);
    }

    @RolesAllowed({ROLE_ADMIN})
    @PostMapping("/countries")
    public ResponseEntity<GeneralCatalogDTO> addCountry(@Validated(GeneralCatalogDTO.New.class)
                                                        @RequestBody GeneralCatalogDTO generalCatalogDTO) {

        return new ResponseEntity<>(catalogService
                .addCountry(generalCatalogDTO.getName()), HttpStatus.OK);
    }

    @RolesAllowed({ROLE_ADMIN})
    @PostMapping("/manufacturers")
    public ResponseEntity<GeneralCatalogDTO> addManufacturer(@Validated(GeneralCatalogDTO.New.class)
                                                             @RequestBody GeneralCatalogDTO generalCatalogDTO) {

        return new ResponseEntity<>(catalogService.addManufacturer(generalCatalogDTO.getName()), HttpStatus.OK);
    }

    @RolesAllowed({ROLE_ADMIN})
    @PostMapping("/packages")
    public ResponseEntity<GeneralCatalogDTO> addPackaging(@Validated(GeneralCatalogDTO.New.class)
                                                          @RequestBody GeneralCatalogDTO generalCatalogDTO) {

        return new ResponseEntity<>(catalogService.addPackaging(generalCatalogDTO.getName()), HttpStatus.OK);
    }

    @RolesAllowed({ROLE_ADMIN})
    @PostMapping("/roastings")
    public ResponseEntity<GeneralCatalogDTO> addRoasting(@Validated(GeneralCatalogDTO.New.class)
                                                         @RequestBody GeneralCatalogDTO generalCatalogDTO) {

        return new ResponseEntity<>(catalogService.addRoasting(generalCatalogDTO.getName()), HttpStatus.OK);
    }

    @RolesAllowed({ROLE_ADMIN})
    @PostMapping("/tea-colors")
    public ResponseEntity<GeneralCatalogDTO> addTeaColor(@Validated(GeneralCatalogDTO.New.class)
                                                         @RequestBody GeneralCatalogDTO generalCatalogDTO) {

        return new ResponseEntity<>(catalogService.addTeaColor(generalCatalogDTO.getName()), HttpStatus.OK);
    }

    @RolesAllowed({ROLE_ADMIN})
    @PostMapping("/tea-types")
    public ResponseEntity<GeneralCatalogDTO> addTeaType(@Validated(GeneralCatalogDTO.New.class)
                                                        @RequestBody GeneralCatalogDTO generalCatalogDTO) {

        return new ResponseEntity<>(catalogService.addTeaType(generalCatalogDTO.getName()), HttpStatus.OK);
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
    @RolesAllowed({ROLE_ADMIN})
    @PutMapping("/coffee-types/{coffeeTypeId}")
    public ResponseEntity<GeneralCatalogDTO> editCoffeeType(@PathVariable Long coffeeTypeId,
                                                            @Validated(GeneralCatalogDTO.New.class)
                                                            @RequestBody GeneralCatalogDTO generalCatalogDTO) {

        return new ResponseEntity<>(catalogService
                .editCoffeeType(coffeeTypeId, generalCatalogDTO.getName()), HttpStatus.OK);
    }

    /**
     * Редактирование элементов стран
     */
    @RolesAllowed({ROLE_ADMIN})
    @PutMapping("/countries/{countryId}")
    public ResponseEntity<GeneralCatalogDTO> editCountry(@PathVariable Long countryId,
                                                         @Validated(GeneralCatalogDTO.New.class)
                                                         @RequestBody GeneralCatalogDTO generalCatalogDTO) {

        return new ResponseEntity<>(catalogService
                .editCountry(countryId, generalCatalogDTO.getName()), HttpStatus.OK);
    }


    /**
     * Редактирование элементов типов производителей
     */
    @RolesAllowed({ROLE_ADMIN})
    @PutMapping("/manufacturers/{manufacturerId}")
    public ResponseEntity<GeneralCatalogDTO> editManufacturer(@PathVariable Long manufacturerId,
                                                              @Validated(GeneralCatalogDTO.New.class)
                                                              @RequestBody GeneralCatalogDTO generalCatalogDTO) {

        return new ResponseEntity<>(catalogService
                .editManufacturer(manufacturerId, generalCatalogDTO.getName()), HttpStatus.OK);
    }


    /**
     * Редактирование элементов типов пакетов
     */
    @RolesAllowed({ROLE_ADMIN})
    @PutMapping("/packages/{packagingId}")
    public ResponseEntity<GeneralCatalogDTO> editPackaging(@PathVariable Long packagingId,
                                                           @Validated(GeneralCatalogDTO.New.class)
                                                           @RequestBody GeneralCatalogDTO generalCatalogDTO) {

        return new ResponseEntity<>(catalogService
                .editPackaging(packagingId, generalCatalogDTO.getName()), HttpStatus.OK);
    }


    /**
     * Редактирование элементов типов обжарки
     */
    @RolesAllowed({ROLE_ADMIN})
    @PutMapping("/roastings/{roastingId}")
    public ResponseEntity<GeneralCatalogDTO> editRoasting(@PathVariable Long roastingId,
                                                          @Validated(GeneralCatalogDTO.New.class)
                                                          @RequestBody GeneralCatalogDTO generalCatalogDTO) {

        return new ResponseEntity<>(catalogService
                .editRoasting(roastingId, generalCatalogDTO.getName()), HttpStatus.OK);
    }


    /**
     * Редактирование элементов цветов чая
     */
    @RolesAllowed({ROLE_ADMIN})
    @PutMapping("/tea-colors/{teaColorId}")
    public ResponseEntity<GeneralCatalogDTO> editTeaColor(@PathVariable Long teaColorId,
                                                          @Validated(GeneralCatalogDTO.New.class)
                                                          @RequestBody GeneralCatalogDTO generalCatalogDTO) {

        return new ResponseEntity<>(catalogService
                .editTeaColor(teaColorId, generalCatalogDTO.getName()), HttpStatus.OK);
    }

    /**
     * Редактирование элементов типов чая
     */
    @RolesAllowed({ROLE_ADMIN})
    @PutMapping("/tea-types/{teaTypeId}")
    public ResponseEntity<GeneralCatalogDTO> editTeaType(@PathVariable Long teaTypeId,
                                                         @Validated(GeneralCatalogDTO.New.class)
                                                         @RequestBody GeneralCatalogDTO generalCatalogDTO) {

        return new ResponseEntity<>(catalogService
                .editTeaType(teaTypeId, generalCatalogDTO.getName()), HttpStatus.OK);
    }


    // Delete - methods

    /**
     * Удаление элементов типов кофе
     */
    @RolesAllowed({ROLE_ADMIN})
    @DeleteMapping("/coffee-type/{coffeeTypeId}")
    public void deleteCoffeeType(@PathVariable Long coffeeTypeId) {

        catalogService.deleteCoffeeType(coffeeTypeId);
    }

    /**
     * Удаление элементов стран
     */
    @RolesAllowed({ROLE_ADMIN})
    @DeleteMapping("/country/{countryId}")
    public void deleteCountry(@PathVariable Long countryId) {

        catalogService.deleteCountry(countryId);
    }

    /**
     * Удаление элементов произваодителей
     */
    @RolesAllowed({ROLE_ADMIN})
    @DeleteMapping("/manufacturer/{manufacturerId}")
    public void deleteManufacturer(@PathVariable Long manufacturerId) {

        catalogService.deleteManufacturer(manufacturerId);
    }

    /**
     * Удаление элементов упаковок
     */
    @RolesAllowed({ROLE_ADMIN})
    @DeleteMapping("/package/{packagingId}")
    public void deletePackaging(@PathVariable Long packagingId) {

        catalogService.deletePackaging(packagingId);
    }

    /**
     * Удаление элементов обжарки кофе
     */
    @RolesAllowed({ROLE_ADMIN})
    @DeleteMapping("/roasting/{roastingId}")
    public void deleteRoasting(@PathVariable Long roastingId) {

        catalogService.deleteRoasting(roastingId);
    }

    /**
     * Удаление элементов цвета чая
     */
    @RolesAllowed({ROLE_ADMIN})
    @DeleteMapping("/tea-color/{teaColorId}")
    public void deleteTeaColor(@PathVariable Long teaColorId) {

        catalogService.deleteTeaColor(teaColorId);
    }

    /**
     * Удаление элементов типа чая
     */
    @RolesAllowed({ROLE_ADMIN})
    @DeleteMapping("/tea-type/{teaTypeId}")
    public void deleteTeaType(@PathVariable Long teaTypeId) {

        catalogService.deleteTeaType(teaTypeId);
    }
}