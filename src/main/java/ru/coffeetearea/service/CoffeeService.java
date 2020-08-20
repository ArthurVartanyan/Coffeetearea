package ru.coffeetearea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.coffeetearea.dto.CoffeeDTO;
import ru.coffeetearea.dto.PageDTO;
import ru.coffeetearea.mappers.CoffeeMapper;
import ru.coffeetearea.model.Coffee;
import ru.coffeetearea.model.Tea;
import ru.coffeetearea.repository.CoffeeRepository;
import ru.coffeetearea.specification.DrinksSpecification;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    private final CoffeeMapper coffeeMapper;



    /**
     * Удалить кофе из списка товаров.
     * На самом деле меняем всего лишь поле is_deleted.
     */
    public void deleteCoffeeFromDrinks(Long coffeeId){

        Coffee coffee = coffeeRepository.getOne(coffeeId);

        coffee.setDeleted(true);

        coffeeRepository.save(coffee);
    }


    /**
     * Добавить новый кофе в список товаров
     *
     * @param coffeeDTO
     * @return
     */
    public CoffeeDTO addCoffee(CoffeeDTO coffeeDTO) {

        Coffee coffee = new Coffee();

        coffee.setName(coffeeDTO.getName());
        coffee.setPrice(coffeeDTO.getPrice());
        coffee.setAbout(coffeeDTO.getAbout());
        coffee.setPackaging(coffeeMapper.coffeeDTOtoCoffee(coffeeDTO).getPackaging());
        coffee.setManufacturer(coffeeMapper.coffeeDTOtoCoffee(coffeeDTO).getManufacturer());
        coffee.setCountry(coffeeMapper.coffeeDTOtoCoffee(coffeeDTO).getCountry());
        coffee.setWeight(coffeeDTO.getWeight());
        coffee.setCoffeeType(coffeeDTO.getCoffeeType());
        coffee.setRoasting(coffeeDTO.getRoasting());
        coffee.setDeleted(false);
        coffeeRepository.save(coffee);

        return coffeeMapper.coffeeToCoffeeDTO(coffee);
    }

    /**
     * Метод для вывода всех кофе
     *
     * @param page
     * @param pageSize
     * @return CoffeesDTOs
     */
    public PageDTO<CoffeeDTO> findAll(int page, int pageSize) {

        // По дефолту он сортирует список по возрастанию цены
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("price").ascending());

        final Page<Coffee> coffees = coffeeRepository.findAll(pageRequest);

        return new PageDTO<>(coffeeMapper.coffeeToCoffeesDTO(coffees));
    }

    /**
     * Метод для возвращение КОФЕ через фильтрацию
     *
     * @param page
     * @param pageSize
     * @param roastingId
     * @param typeId
     * @param countryId
     * @return filtered Coffees(DTOs)
     */
    public PageDTO<CoffeeDTO> findAllFilter(int page, int pageSize, Long roastingId, Long typeId,
                                            Long countryId, BigDecimal min, BigDecimal max) {

        // По дефолту он сортирует список по возрастанию цены
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("price").ascending());

        final Page<Coffee> coffees = coffeeRepository
                .findAll(DrinksSpecification
                        .getCoffeesByFilter(roastingId, typeId, countryId, min, max), pageRequest);

        return new PageDTO<>(coffeeMapper.coffeeToCoffeesDTO(coffees));
    }
}