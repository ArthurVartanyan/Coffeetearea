package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.coffeetearea.dto.CoffeeDTO;
import ru.coffeetearea.dto.DrinkDTO;
import ru.coffeetearea.dto.PageDTO;
import ru.coffeetearea.dto.SortingParams;
import ru.coffeetearea.service.CoffeeService;

import javax.annotation.security.RolesAllowed;
import java.math.BigDecimal;

import static ru.coffeetearea.model.Role.ROLE_ADMIN;
import static ru.coffeetearea.model.Role.ROLE_CUSTOMER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coffee")
@Api(value = "Coffee", tags = {"Coffee"})
public class CoffeeController {

    // Fields

    private final CoffeeService coffeeService;


    // PUT - methods

    /**
     * Редактирование напитка кофе
     */
    @RolesAllowed({ROLE_ADMIN})
    @PutMapping("/{coffeeId}")
    public ResponseEntity<CoffeeDTO> editCoffee(@PathVariable Long coffeeId,
                                                @Validated(DrinkDTO.Edit.class) @RequestBody CoffeeDTO coffeeDTO) {

        return new ResponseEntity<>(coffeeService.editCoffee(coffeeId, coffeeDTO), HttpStatus.OK);
    }


    // POST - methods

    /**
     * Добавить кофе в список товаров
     *
     * @param coffeeDTO
     */
    @RolesAllowed({ROLE_ADMIN})
    @PostMapping
    public ResponseEntity<CoffeeDTO> addCoffee(@Validated(CoffeeDTO.New.class) @RequestBody CoffeeDTO coffeeDTO) {
        return new ResponseEntity<>(coffeeService.addCoffee(coffeeDTO), HttpStatus.OK);
    }


    // GET - methods

    /**
     * Получение одного напитка
     */
    @RolesAllowed({ROLE_CUSTOMER})
    @GetMapping("/{coffeeId}")
    public CoffeeDTO findCoffee(@PathVariable Long coffeeId){

        return coffeeService.findCoffee(coffeeId);
    }


    /**
     * Получение списка товаров
     */
    @GetMapping("/all")
    public PageDTO<CoffeeDTO> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "page_size", defaultValue = "4") int pageSize,
                                      @RequestParam(required = false, defaultValue = "NAME_INCREASE")
                                              SortingParams sortingParams) {

        return coffeeService.findAll(page, pageSize, sortingParams);
    }

    /**
     * Поиск напитка по фильтрам
     *
     * @param page
     * @param pageSize
     * @param roastingId
     * @param typeId
     * @param countryId
     * @param min
     * @param max
     */
    @GetMapping("/filter")
    public PageDTO<CoffeeDTO> findAllFilter(@RequestParam(value = "page", defaultValue = "0") int page,
                                            @RequestParam(value = "page_size", defaultValue = "5") int pageSize,
                                            @RequestParam(required = false) Long roastingId,
                                            @RequestParam(required = false) Long typeId,
                                            @RequestParam(required = false) Long countryId,
                                            BigDecimal min, BigDecimal max,
                                            @RequestParam(required = false, defaultValue = "NAME_INCREASE")
                                                    SortingParams sortingParams) {

        return coffeeService.findAllFilter(page, pageSize, roastingId, typeId, countryId, min, max, sortingParams);
    }


    // Delete - methods

    /**
     * Удалить кофе из товаров
     *
     * @param coffeeId
     */
    @RolesAllowed({ROLE_ADMIN})
    @DeleteMapping("/{coffeeId}")
    public void deleteCoffeeFromDrinks(@PathVariable Long coffeeId) {

        coffeeService.deleteCoffeeFromDrinks(coffeeId);
    }
}