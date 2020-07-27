package ru.coffeetearea.service.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.coffeetearea.model.catalog.*;
import ru.coffeetearea.repository.catalog.*;

import java.util.List;

@Service
public class CatalogService {

    // Fields
    //
    protected CountriesRepository countriesRepository;

    protected ManufacturerRepository manufacturerRepository;

    protected RoastingRepository roastingRepository;

    protected PackagingRepository packagingRepository;

    protected TeaColorRepository teaColorRepository;

    protected CoffeeTypeRepository coffeeTypeRepository;

    protected TeaTypeRepository teaTypeRepository;


    // Setters
    //
    @Autowired
    public void setCountriesRepository(CountriesRepository countriesRepository) {
        this.countriesRepository = countriesRepository;
    }

    @Autowired
    public void setManufacturerRepository(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Autowired
    public void setRoastingRepository(RoastingRepository roastingRepository) {
        this.roastingRepository = roastingRepository;
    }

    @Autowired
    public void setPackagingRepository(PackagingRepository packagingRepository) {
        this.packagingRepository = packagingRepository;
    }

    @Autowired
    public void setTeaColorRepository(TeaColorRepository teaColorRepository) {
        this.teaColorRepository = teaColorRepository;
    }

    @Autowired
    public void setCoffeeTypeRepository(CoffeeTypeRepository coffeeTypeRepository) {
        this.coffeeTypeRepository = coffeeTypeRepository;
    }

    @Autowired
    public void setTeaTypeRepository(TeaTypeRepository teaTypeRepository) {
        this.teaTypeRepository = teaTypeRepository;
    }
    //


    // Methods
    //
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