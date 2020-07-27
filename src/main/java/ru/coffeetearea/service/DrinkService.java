package ru.coffeetearea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.coffeetearea.model.Drink;
import ru.coffeetearea.repository.DrinkRepository;

import java.util.List;

@Service
public class DrinkService {

    // Fields
    //
    private DrinkRepository drinkRepository;


    // Setters
    // DI are here
    @Autowired
    public void setDrinkRepository(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }


    // Methods
    //
    // Получение списка товаров
    public List<Drink> getAllDrinks() {

        return drinkRepository.findAll();
    }
}