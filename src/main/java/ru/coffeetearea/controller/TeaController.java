package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.coffeetearea.dto.PageDTO;
import ru.coffeetearea.dto.TeaDTO;
import ru.coffeetearea.service.TeaService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/tea")
@RequiredArgsConstructor
@Api(value = "Tea", tags = {"Tea"})
public class TeaController {

    // Fields

    private final TeaService teaService;


    // GET - methods

    /**
     * Получение списка товаров
     */
    @GetMapping("/teas")
    public PageDTO<TeaDTO> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "page_size", defaultValue = "5") int pageSize) {

        return teaService.findAll(page, pageSize);
    }

    @GetMapping("/teas-filter")
    public PageDTO<TeaDTO> findAllByFilter(@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "page_size", defaultValue = "5") int pageSize,
                                           @RequestParam(required = false) Long colorId,
                                           @RequestParam(required = false) Long typeId,
                                           @RequestParam(required = false) Long countryId,
                                           BigDecimal min, BigDecimal max) {

        return teaService.findAllByFilter(page, pageSize, colorId, typeId, countryId, min, max);
    }
}