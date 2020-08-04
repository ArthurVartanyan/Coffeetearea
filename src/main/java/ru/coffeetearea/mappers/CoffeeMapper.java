package ru.coffeetearea.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import ru.coffeetearea.dto.CoffeeDTO;
import ru.coffeetearea.model.Coffee;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {

    CoffeeMapper INSTANCE = Mappers.getMapper(CoffeeMapper.class);

    CoffeeDTO coffeeToCoffeeDTO(Coffee coffee);

    Coffee coffeeDTOtoCoffee(CoffeeDTO coffeeDTO);

    @IterableMapping(qualifiedByName = "coffeeToCoffeeDTO")
    default Page<CoffeeDTO> coffeeToCoffeesDTO(Page<Coffee> coffees) {
        return coffees.map(this::coffeeToCoffeeDTO);
    }
}