package ru.coffeetearea.service.catalog;

import org.springframework.stereotype.Service;
import ru.coffeetearea.model.catalog.*;

import java.util.List;

@Service
public class CatalogService extends GeneralCatalogService {

    // Получение списка стран
    public List<Countries> findCountries(){
        return countriesRepository.findAll();
    }

    // Получение списка производителей
    public List<Manufacturer> findManufacturers(){
        return manufacturerRepository.findAll();
    }

    // Получение списка обжарки
    public List<Roasting> findRoastings(){
        return roastingRepository.findAll();
    }

    // Получение списка упаковок
    public List<Packaging> findPackagings(){
        return packagingRepository.findAll();
    }

    // Получение списка цвета чая
    public List<TeaColor> findTeaColors(){
        return teaColorRepository.findAll();
    }

    // Получение списка типов кофе
    public List<CoffeeType> findCoffeeTypes(){
        return coffeeTypeRepository.findAll();
    }

    // Получение списка типов чая
    public List<TeaType> findTeaTypes(){
        return teaTypeRepository.findAll();
    }
}