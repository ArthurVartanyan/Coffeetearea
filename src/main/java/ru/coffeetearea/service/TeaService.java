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
import ru.coffeetearea.model.Tea;
import ru.coffeetearea.repository.TeaRepository;
import ru.coffeetearea.specification.CoffeeSpecification;
import ru.coffeetearea.specification.TeaSpecification;

@Service
@RequiredArgsConstructor
public class TeaService {

    private final TeaRepository teaRepository;

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

        final Page<Tea> teas = teaRepository.findAll(pageRequest);

        return new PageDTO<>(drinkMapper.drinksToDrinksDTO(teas));
    }

    /**
     * Метод для возвращение КОФЕ через фильтрацию
     *
     * @param page
     * @param pageSize
     * @param colorId
     * @param typeId
     * @param typeId
     * @return filtered Coffees(DTOs)
     */
    public PageDTO<DrinkDTO> findAllByFilter(int page, int pageSize, Long colorId,
                                             Long typeId, Long countryId) {

        // По дефолту он сортирует список по возрастанию цены
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("price").ascending());

        final Page<Tea> teas = teaRepository
                .findAll(TeaSpecification.getTeasByFilter(colorId, typeId, countryId), pageRequest);

        return new PageDTO<>(drinkMapper.drinksToDrinksDTO(teas));
    }
}