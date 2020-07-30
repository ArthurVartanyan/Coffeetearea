package ru.coffeetearea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.coffeetearea.DTO.DrinkDTO;
import ru.coffeetearea.DTO.PageDTO.PageDTO;
import ru.coffeetearea.mappers.DrinkMapper;
import ru.coffeetearea.model.Drink;
import ru.coffeetearea.repository.DrinkRepository;
import ru.coffeetearea.repository.OrderRepository;

@RequiredArgsConstructor
@Service
public class DrinkService {

    // Fields
    //
    private final DrinkRepository drinkRepository;

    private final OrderRepository orderRepository;

    private final DrinkMapper drinkMapper;


    // Methods
    //
    //
    /**
     * Получение списка товаров
     * @param page
     * @param pageSize
     * @return drinksDTOs
     */
    public PageDTO<DrinkDTO> getAllDrinks(int page, int pageSize) {

        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("id"));

        final Page<Drink> drinks = drinkRepository.findAll(pageRequest);

        return new PageDTO<DrinkDTO>(drinkMapper.drinksToDrinksDTO(drinks));
    }


//    public Page<DrinkDTO> getPopularDrinks(int page, int pageSize) {
//
//        List<Drink> popularDrinks = orderRepository.f
//
//        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by())
//    }
}