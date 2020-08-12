package ru.coffeetearea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.coffeetearea.dto.DrinkDTO;
import ru.coffeetearea.dto.PageDTO;
import ru.coffeetearea.mappers.DrinkMapper;
import ru.coffeetearea.model.Drink;
import ru.coffeetearea.repository.DrinkRepository;

@Service
@RequiredArgsConstructor
public class DrinkService {

    private final DrinkRepository drinkRepository;

    private final DrinkMapper drinkMapper;


    /**
     * Получение списка товаров
     *
     * @param page
     * @param pageSize
     * @return drinksDTOs
     */
    public PageDTO<DrinkDTO> findAllDrinks(int page, int pageSize) {

        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("id"));

        final Page<Drink> drinks = drinkRepository.findAll(pageRequest);

        return new PageDTO<DrinkDTO>(drinkMapper.drinksToDrinksDTO(drinks));
    }
}