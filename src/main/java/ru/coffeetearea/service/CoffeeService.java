package ru.coffeetearea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.coffeetearea.DTO.DrinkDTO;
import ru.coffeetearea.DTO.PageDTO.PageDTO;
import ru.coffeetearea.mappers.DrinkMapper;
import ru.coffeetearea.model.Coffee;
import ru.coffeetearea.repository.CoffeeRepository;
import ru.coffeetearea.specification.CoffeeSpecification;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    private final DrinkMapper drinkMapper;


    // Methods
    //
    //

    /**
     * Метод для вывода всех кофе
     *
     * @param page
     * @param pageSize
     * @return CoffeesDTOs
     */
    public PageDTO<DrinkDTO> findAll(int page, int pageSize) {

        // По дефолту он сортирует список по возрастанию цены
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("price").ascending());

        final Page<Coffee> coffees = coffeeRepository.findAll(pageRequest);

        return new PageDTO<>(drinkMapper.drinksToDrinksDTO(coffees));
    }

    /**
     * Метод для возвращение КОФЕ через фильтрацию
     *
     * @param page
     * @param pageSize
     * @param roastingId
     * @param typeId
     * @param countryId
     * @return filtered Coffees(DTOs)
     */
    public PageDTO<DrinkDTO> findAllFilter(int page, int pageSize, Long roastingId, Long typeId, Long countryId) {

        // По дефолту он сортирует список по возрастанию цены
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("price").ascending());

        final Page<Coffee> coffees = coffeeRepository
                .findAll(CoffeeSpecification.getCoffeesByFilter(roastingId, typeId, countryId), pageRequest);

        return new PageDTO<>(drinkMapper.drinksToDrinksDTO(coffees));
    }
}