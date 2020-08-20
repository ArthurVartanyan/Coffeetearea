package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.coffeetearea.dto.CoffeeDTO;
import ru.coffeetearea.dto.PageDTO;
import ru.coffeetearea.service.CoffeeService;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coffee")
@Api(value = "Coffee", tags = {"Coffee"})
public class CoffeeController {

    // Fields

    private final CoffeeService coffeeService;


    // GET - methods

    /**
     * Получение списка товаров
     */
    @GetMapping("/coffees")
    public PageDTO<CoffeeDTO> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "page_size", defaultValue = "5") int pageSize) {

        return coffeeService.findAll(page, pageSize);
    }

    @GetMapping("/coffees-filter")
    public PageDTO<CoffeeDTO> findAllFilter(@RequestParam(value = "page", defaultValue = "0") int page,
                                            @RequestParam(value = "page_size", defaultValue = "5") int pageSize,
                                            @RequestParam(required = false) Long roastingId,
                                            @RequestParam(required = false) Long typeId,
                                            @RequestParam(required = false) Long countryId,
                                            BigDecimal min, BigDecimal max) {

        return coffeeService.findAllFilter(page, pageSize, roastingId, typeId, countryId, min, max);
    }
}