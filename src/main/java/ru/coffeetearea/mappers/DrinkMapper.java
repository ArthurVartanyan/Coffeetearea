package ru.coffeetearea.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import ru.coffeetearea.dto.DrinkDTO;
import ru.coffeetearea.model.Drink;

@Mapper(componentModel = "spring")
public interface DrinkMapper {

    DrinkMapper INSTANCE = Mappers.getMapper(DrinkMapper.class);

    DrinkDTO drinkToDrinkDTO(Drink drink);

    Drink drinkDTOtoDrink(DrinkDTO drinkDTO);

    @IterableMapping(qualifiedByName = "drinkToDrinkDTO")
    default Page<DrinkDTO> drinksToDrinksDTO(Page<? extends Drink> drinks) {
        return drinks.map(this::drinkToDrinkDTO);
    }
}