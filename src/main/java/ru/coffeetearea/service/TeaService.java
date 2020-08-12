package ru.coffeetearea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.coffeetearea.dto.PageDTO;
import ru.coffeetearea.dto.TeaDTO;
import ru.coffeetearea.mappers.TeaMapper;
import ru.coffeetearea.model.Tea;
import ru.coffeetearea.repository.TeaRepository;
import ru.coffeetearea.specification.DrinksSpecification;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TeaService {

    private final TeaRepository teaRepository;

    private final TeaMapper teaMapper;


    /**
     * Метод для вывода всех кофе
     *
     * @param page
     * @param pageSize
     * @return CoffeesDTOs
     */
    public PageDTO<TeaDTO> findAll(int page, int pageSize) {

        // По дефолту он сортирует список по возрастанию цены
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("price").ascending());

        final Page<Tea> teas = teaRepository.findAll(pageRequest);

        return new PageDTO<>(teaMapper.teaToTeasDTO(teas));
    }


    /**
     * Метод для возвращение КОФЕ через фильтрацию
     *
     * @param page
     * @param pageSize
     * @param colorId
     * @param typeId
     * @param countryId
     * @return filtered Coffees(DTOs)
     */
    public PageDTO<TeaDTO> findAllByFilter(int page, int pageSize, Long colorId,
                                           Long typeId, Long countryId, BigDecimal min, BigDecimal max) {

        // По дефолту он сортирует список по возрастанию цены
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("price").ascending());

        final Page<Tea> teas = teaRepository
                .findAll(DrinksSpecification
                        .getTeasByFilter(colorId, typeId, countryId, min, max), pageRequest);

        return new PageDTO<>(teaMapper.teaToTeasDTO(teas));
    }
}