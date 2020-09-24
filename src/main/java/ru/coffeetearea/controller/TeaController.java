package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.coffeetearea.dto.CoffeeDTO;
import ru.coffeetearea.dto.PageDTO;
import ru.coffeetearea.dto.SortingParams;
import ru.coffeetearea.dto.TeaDTO;
import ru.coffeetearea.service.TeaService;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.math.BigDecimal;

import static ru.coffeetearea.model.Role.ROLE_ADMIN;
import static ru.coffeetearea.model.Role.ROLE_CUSTOMER;

@RestController
@RequestMapping("/tea")
@RequiredArgsConstructor
@Api(value = "Tea", tags = {"Tea"})
public class TeaController {

    // Fields

    private final TeaService teaService;


    // PUT - methods

    /**
     * Редактирование напитка чая
     */
    @RolesAllowed({ROLE_ADMIN})
    @PutMapping("/{teaId}")
    public ResponseEntity<TeaDTO> editTea(@PathVariable Long teaId,
                                          @Validated(TeaDTO.Edit.class) @RequestBody TeaDTO teaDTO) {

        return new ResponseEntity<>(teaService.editTea(teaId, teaDTO), HttpStatus.OK);
    }


    // POST - methods

    /**
     * Добавить чай в список товаров
     *
     * @param teaDTO
     */
    @RolesAllowed({ROLE_ADMIN})
    @PostMapping
    public ResponseEntity<TeaDTO> addTea(@Validated(TeaDTO.New.class) @RequestBody TeaDTO teaDTO) {
        return new ResponseEntity<>(teaService.addTea(teaDTO), HttpStatus.OK);
    }


    // GET - methods

    /**
     * Получение одного напитка
     */
    @RolesAllowed({ROLE_CUSTOMER})
    @GetMapping("/{teaId}")
    public TeaDTO findTea(@PathVariable Long teaId){

        return teaService.findTea(teaId);
    }


    /**
     * Получение списка товаров
     */
    @GetMapping("/all")
    public PageDTO<TeaDTO> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "page_size", defaultValue = "4") int pageSize,
                                   @RequestParam(required = false, defaultValue = "NAME_INCREASE")
                                           SortingParams sortingParams) {

        return teaService.findAll(page, pageSize, sortingParams);
    }

    /**
     * Получаем чай с фильтрами
     *
     * @param page
     * @param pageSize
     * @param colorId
     * @param typeId
     * @param countryId
     * @param min
     * @param max
     * @param sortingParams
     */
    @GetMapping("/filter")
    public PageDTO<TeaDTO> findAllByFilter(@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "page_size", defaultValue = "5") int pageSize,
                                           @RequestParam(required = false) Long colorId,
                                           @RequestParam(required = false) Long typeId,
                                           @RequestParam(required = false) Long countryId,
                                           BigDecimal min, BigDecimal max,
                                           @RequestParam(required = false, defaultValue = "NAME_INCREASE")
                                                   SortingParams sortingParams) {

        return teaService.findAllByFilter(page, pageSize, colorId, typeId, countryId, min, max, sortingParams);
    }

    // Delete - methods

    /**
     * Удалить кофе из товаров
     *
     * @param teaId
     */
    @RolesAllowed({ROLE_ADMIN})
    @DeleteMapping("/{teaId}")
    public void deleteTeaFromDrinks(@PathVariable Long teaId) {

        teaService.deleteTeaFromDrinks(teaId);
    }
}