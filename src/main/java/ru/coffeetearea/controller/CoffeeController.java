package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.coffeetearea.DTO.DrinkDTO;
import ru.coffeetearea.DTO.PageDTO.PageDTO;
import ru.coffeetearea.service.CoffeeService;

import java.math.BigDecimal;

@Api(value = "Coffee", tags = {"Coffee"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    private final CoffeeService coffeeService;


    // Methods
    //
    // GET - methods
    //

    /**
     * Получение списка товаров
     */
    @GetMapping("/coffees")
    private PageDTO<DrinkDTO> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "page_size", defaultValue = "5") int pageSize) {

        return coffeeService.findAll(page, pageSize);
    }

    @GetMapping("/filter/coffees")
    private PageDTO<DrinkDTO> findAllFilter(@RequestParam(value = "page", defaultValue = "0") int page,
                                            @RequestParam(value = "page_size", defaultValue = "5") int pageSize,
                                            @RequestParam(required = false) Long roastingId,
                                            @RequestParam(required = false) Long typeId,
                                            @RequestParam(required = false) Long countryId,
                                            @RequestParam(required = false, defaultValue = "0") BigDecimal min,
                                            @RequestParam(required = false, defaultValue = "10000") BigDecimal max) {

        return coffeeService.findAllFilter(page, pageSize, roastingId, typeId, countryId, min, max);
    }
}
