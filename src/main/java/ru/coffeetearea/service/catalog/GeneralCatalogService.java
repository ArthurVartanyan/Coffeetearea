package ru.coffeetearea.service.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import ru.coffeetearea.repository.catalog.*;

public abstract class GeneralCatalogService {

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
}