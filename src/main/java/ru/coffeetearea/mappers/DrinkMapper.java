package ru.coffeetearea.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.coffeetearea.DTO.DrinkDTO;
import ru.coffeetearea.model.Drink;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DrinkMapper {

    DrinkMapper INSTANCE = Mappers.getMapper(DrinkMapper.class);

    @Mapping(source = "name", target = "drinkName")
    @Mapping(source = "price", target = "drinkPrice")
    @Mapping(source = "about", target = "drinkAbout")
    @Mapping(source = "packaging", target = "drinkPackaging")
    @Mapping(source = "manufacturer", target = "drinkManufacturer")
    @Mapping(source = "countries", target = "drinkCountries")
    DrinkDTO drinkToDrinkDTO(Drink drink);

    @Mapping(source = "drinkName", target = "name")
    @Mapping(source = "drinkPrice", target = "price")
    @Mapping(source = "drinkAbout", target = "about")
    @Mapping(source = "drinkPackaging", target = "packaging")
    @Mapping(source = "manufacturer", target = "drinkManufacturer")
    @Mapping(source = "countries", target = "drinkCountries")
    Drink drinkDTOtoDrink(DrinkDTO drinkDTO);

    @IterableMapping(qualifiedByName = "drinkToDrinkDTO")
    List<DrinkDTO> drinksToDrinksDTO(List<Drink> drinks);
}
