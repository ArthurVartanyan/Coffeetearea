package ru.coffeetearea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import ru.coffeetearea.DTO.DrinkDTO;
import ru.coffeetearea.mappers.DrinkMapper;
import ru.coffeetearea.model.Drink;
import ru.coffeetearea.repository.DrinkRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DrinkService {

    // Fields
    //
    private final DrinkRepository drinkRepository;

    private final DrinkMapper drinkMapper;


    // Methods
    //
    /* Получение списка товаров */
    public List<DrinkDTO> getAllDrinks() {

        Pageable page = PageRequest.of(0, 4, Sort.by("price"));

        final Page<Drink> drinks = drinkRepository.findAll(page);

        return drinkMapper.drinksToDrinksDTO(drinks);
    }
}