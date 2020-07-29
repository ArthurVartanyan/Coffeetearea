package ru.coffeetearea.service.catalog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coffeetearea.mappers.DrinkMapper;
import ru.coffeetearea.model.catalog.*;
import ru.coffeetearea.repository.catalog.*;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CatalogService {

    // Fields
    //
    private final CountriesRepository countriesRepository;

    private final ManufacturerRepository manufacturerRepository;

    private final RoastingRepository roastingRepository;

    private final PackagingRepository packagingRepository;

    private final TeaColorRepository teaColorRepository;

    private final CoffeeTypeRepository coffeeTypeRepository;

    private final TeaTypeRepository teaTypeRepository;


    // Methods
    //
    //
    /* Получение списка стран */
    public List<Countries> findCountries() {
        return countriesRepository.findAll();
    }

    /* Получение списка производителей */
    public List<Manufacturer> findManufacturers() {
        return manufacturerRepository.findAll();
    }

    /* Получение списка обжарки */
    public List<Roasting> findRoastings() {
        return roastingRepository.findAll();
    }

    /* Получение списка упаковок */
    public List<Packaging> findPackagings() {
        return packagingRepository.findAll();
    }

    /* Получение списка цвета чая */
    public List<TeaColor> findTeaColors() {
        return teaColorRepository.findAll();
    }

    /* Получение списка типов кофе */
    public List<CoffeeType> findCoffeeTypes() {
        return coffeeTypeRepository.findAll();
    }

    /* Получение списка типов чая */
    public List<TeaType> findTeaTypes() {
        return teaTypeRepository.findAll();
    }
}