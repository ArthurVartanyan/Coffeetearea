package ru.coffeetearea.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import ru.coffeetearea.DTO.DrinkDTO;
import ru.coffeetearea.model.Drink;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DrinkMapper {

    DrinkMapper INSTANCE = Mappers.getMapper(DrinkMapper.class);

    DrinkDTO drinkToDrinkDTO(Drink drink);

    Drink drinkDTOtoDrink(DrinkDTO drinkDTO);

    @IterableMapping(qualifiedByName = "drinkToDrinkDTO")
    Page<DrinkDTO> drinksToDrinksDTO(List<Drink> drinks);
}