package ru.coffeetearea.service.catalog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coffeetearea.mappers.CatalogMapper;
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

    private final CatalogMapper catalogMapper;


    // Получение списка стран
    public List<?> findCountries(){
        return catalogMapper.catalogsToCatalogsDTO(countriesRepository.findAll());
    }

    // Получение списка производителей
    public List<?> findManufacturers(){
        return catalogMapper.catalogsToCatalogsDTO(manufacturerRepository.findAll());
    }

    // Получение списка обжарки
    public List<?> findRoastings(){
        return catalogMapper.catalogsToCatalogsDTO(roastingRepository.findAll()) ;
    }

    // Получение списка упаковок
    public List<?> findPackages(){
        return catalogMapper.catalogsToCatalogsDTO(packagingRepository.findAll());
    }

    // Получение списка цвета чая
    public List<?> findTeaColors(){
        return catalogMapper.catalogsToCatalogsDTO(teaColorRepository.findAll());
    }

    // Получение списка типов кофе
    public List<?> findCoffeeTypes(){
        return catalogMapper.catalogsToCatalogsDTO(coffeeTypeRepository.findAll());
    }

    // Получение списка типов чая
    public List<?> findTeaTypes(){
        return catalogMapper.catalogsToCatalogsDTO(teaTypeRepository.findAll());
    }
}