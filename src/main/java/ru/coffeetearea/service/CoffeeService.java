package ru.coffeetearea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.coffeetearea.dto.CoffeeDTO;
import ru.coffeetearea.dto.DrinkDTO;
import ru.coffeetearea.dto.PageDTO;
import ru.coffeetearea.dto.SortingParams;
import ru.coffeetearea.exceptions.EntityNotFoundException;
import ru.coffeetearea.mappers.CoffeeMapper;
import ru.coffeetearea.model.Coffee;
import ru.coffeetearea.repository.CoffeeRepository;
import ru.coffeetearea.specification.DrinksSpecification;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    private final CoffeeMapper coffeeMapper;

    private final DrinkService drinkService;


    /**
     * Получить один напиток по ИД
     */
    public CoffeeDTO findCoffee(Long coffeeId){

        return coffeeMapper.coffeeToCoffeeDTO(coffeeRepository.findById(coffeeId)
                .orElseThrow(() -> new EntityNotFoundException(coffeeId)));
    }


    /**
     * Редктирование напитка кофе
     *
     * @param coffeeDTO
     * @return coffeeDTO
     */
    public CoffeeDTO editCoffee(Long coffeeId, CoffeeDTO coffeeDTO) {

        Coffee coffee = coffeeRepository.findById(coffeeId)
                .orElseThrow(() -> new EntityNotFoundException(coffeeId));

        coffeeDTO.setId(coffeeId);

        coffeeRepository.save(coffeeMapper.coffeeDTOtoCoffee(coffeeDTO));

        return coffeeMapper.coffeeToCoffeeDTO(coffeeRepository.getOne(coffeeId));
    }


    /**
     * Удалить кофе из списка товаров.
     * На самом деле меняем всего лишь поле is_deleted.
     */
    public void deleteCoffeeFromDrinks(Long coffeeId) {

        Coffee coffee = coffeeRepository.findById(coffeeId)
                .orElseThrow(() -> new EntityNotFoundException(coffeeId));

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

        Coffee coffee = coffeeMapper.coffeeDTOtoCoffee(coffeeDTO);

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
    public PageDTO<CoffeeDTO> findAll(int page, int pageSize, SortingParams sortingParams) {

        final Page<Coffee> coffees = coffeeRepository
                .findAllByDeletedIsFalse(drinkService.sortingWithParams(sortingParams, page, pageSize));

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
     * @param sortingParams
     * @return filtered Coffees(DTOs)
     */
    public PageDTO<CoffeeDTO> findAllFilter(int page, int pageSize, String drinkName, Long roastingId, Long typeId, Long countryId,
                                            BigDecimal min, BigDecimal max, SortingParams sortingParams) {

        final Page<Coffee> coffees = coffeeRepository
                .findAll(DrinksSpecification
                                .getCoffeesByFilter(drinkName, roastingId, typeId, countryId, min, max),
                        drinkService.sortingWithParams(sortingParams, page, pageSize));

        return new PageDTO<>(coffeeMapper.coffeeToCoffeesDTO(coffees));
    }
}