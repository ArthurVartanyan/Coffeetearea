package ru.coffeetearea.service.catalog;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.coffeetearea.dto.GeneralCatalogDTO;
import ru.coffeetearea.mappers.CatalogMapper;
import ru.coffeetearea.model.catalog.*;
import ru.coffeetearea.repository.catalog.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogService {

    private final CountryRepository countriesRepository;

    private final ManufacturerRepository manufacturerRepository;

    private final RoastingRepository roastingRepository;

    private final PackagingRepository packagingRepository;

    private final TeaColorRepository teaColorRepository;

    private final CoffeeTypeRepository coffeeTypeRepository;

    private final TeaTypeRepository teaTypeRepository;

    private final CatalogMapper catalogMapper;


    /**
     * Редактирование элементов типов кофе
     */
    public GeneralCatalogDTO editCoffeeType(Long coffeeTypeId, String name) {

        CoffeeType coffeeType = coffeeTypeRepository.getOne(coffeeTypeId);
        coffeeType.setName(name);
        coffeeTypeRepository.save(coffeeType);

        return catalogMapper.catalogToCatalogsDTO(coffeeType);
    }

    /**
     * Редактирование элементов стран
     */
    public GeneralCatalogDTO editCountry(Long countryId, String name) {

        Country country = countriesRepository.getOne(countryId);
        country.setName(name);
        countriesRepository.save(country);

        return catalogMapper.catalogToCatalogsDTO(country);
    }


    /**
     * Редактирование элементов типов производителей
     */
    public GeneralCatalogDTO editManufacturer(Long manufacturerId, String name) {

        Manufacturer manufacturer = manufacturerRepository.getOne(manufacturerId);
        manufacturer.setName(name);
        manufacturerRepository.save(manufacturer);

        return catalogMapper.catalogToCatalogsDTO(manufacturer);
    }


    /**
     * Редактирование элементов типов пакетов
     */
    public GeneralCatalogDTO editPackaging(Long packagingId, String name) {

        Packaging packaging = packagingRepository.getOne(packagingId);
        packaging.setName(name);
        packagingRepository.save(packaging);

        return catalogMapper.catalogToCatalogsDTO(packaging);
    }


    /**
     * Редактирование элементов типов обжарки
     */
    public GeneralCatalogDTO editRoasting(Long roastingId, String name) {

        Roasting roasting = roastingRepository.getOne(roastingId);
        roasting.setName(name);
        roastingRepository.save(roasting);

        return catalogMapper.catalogToCatalogsDTO(roasting);
    }


    /**
     * Редактирование элементов цветов чая
     */
    public GeneralCatalogDTO editTeaColor(Long teaColorId, String name) {

        TeaColor teaColor = teaColorRepository.getOne(teaColorId);
        teaColor.setName(name);
        teaColorRepository.save(teaColor);

        return catalogMapper.catalogToCatalogsDTO(teaColor);
    }

    /**
     * Редактирование элементов типов чая
     */
    public GeneralCatalogDTO editTeaType(Long teaTypeId, String name) {

        TeaType teaType = teaTypeRepository.getOne(teaTypeId);
        teaType.setName(name);
        teaTypeRepository.save(teaType);

        return catalogMapper.catalogToCatalogsDTO(teaType);
    }



    /**
     * Создание элементов типов кофе
     */
    public GeneralCatalogDTO addCoffeeType(String name) {

        CoffeeType coffeeType = new CoffeeType();
        coffeeType.setDeleted(false);
        coffeeType.setName(name);
        coffeeTypeRepository.save(coffeeType);

        return catalogMapper.catalogToCatalogsDTO(coffeeType);
    }

    /**
     * Создание элементов стран
     */
    public GeneralCatalogDTO addCountry(String name) {

        Country country = new Country();
        country.setDeleted(false);
        country.setName(name);
        countriesRepository.save(country);

        return catalogMapper.catalogToCatalogsDTO(country);
    }


    /**
     * Создание элементов типов производителей
     */
    public GeneralCatalogDTO addManufacturer(String name) {

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setDeleted(false);
        manufacturer.setName(name);
        manufacturerRepository.save(manufacturer);

        return catalogMapper.catalogToCatalogsDTO(manufacturer);
    }


    /**
     * Создание элементов типов пакетов
     */
    public GeneralCatalogDTO addPackaging(String name) {

        Packaging packaging = new Packaging();
        packaging.setDeleted(false);
        packaging.setName(name);
        packagingRepository.save(packaging);

        return catalogMapper.catalogToCatalogsDTO(packaging);
    }


    /**
     * Создание элементов типов обжарки
     */
    public GeneralCatalogDTO addRoasting(String name) {

        Roasting roasting = new Roasting();
        roasting.setDeleted(false);
        roasting.setName(name);
        roastingRepository.save(roasting);

        return catalogMapper.catalogToCatalogsDTO(roasting);
    }


    /**
     * Создание элементов цветов чая
     */
    public GeneralCatalogDTO addTeaColor(String name) {

        TeaColor teaColor = new TeaColor();
        teaColor.setDeleted(false);
        teaColor.setName(name);
        teaColorRepository.save(teaColor);

        return catalogMapper.catalogToCatalogsDTO(teaColor);
    }

    /**
     * Создание элементов типов чая
     */
    public GeneralCatalogDTO addTeaType(String name) {

        TeaType teaType = new TeaType();
        teaType.setDeleted(false);
        teaType.setName(name);
        teaTypeRepository.save(teaType);

        return catalogMapper.catalogToCatalogsDTO(teaType);
    }


    /**
     * Удаление элементов типов кофе
     */
    public void deleteCoffeeType(Long coffeeTypeId) {

        CoffeeType coffeeType = coffeeTypeRepository.getOne(coffeeTypeId);
        coffeeType.setDeleted(true);
        coffeeTypeRepository.save(coffeeType);

    }

    /**
     * Удаление элементов стран
     */
    public void deleteCountry(Long countryId) {

        Country country = countriesRepository.getOne(countryId);
        country.setDeleted(true);
        countriesRepository.save(country);
    }

    /**
     * Удаление элементов произваодителей
     */
    public void deleteManufacturer(Long manufacturerId) {

        Manufacturer manufacturer = manufacturerRepository.getOne(manufacturerId);
        manufacturer.setDeleted(true);
        manufacturerRepository.save(manufacturer);
    }

    /**
     * Удаление элементов упаковок
     */
    public void deletePackaging(Long packagingId) {

        Packaging packaging = packagingRepository.getOne(packagingId);
        packaging.setDeleted(true);
        packagingRepository.save(packaging);
    }

    /**
     * Удаление элементов обжарки кофе
     */
    public void deleteRoasting(Long roastingId) {

        Roasting roasting = roastingRepository.getOne(roastingId);
        roasting.setDeleted(true);
        roastingRepository.save(roasting);
    }

    /**
     * Удаление элементов цвета чая
     */
    public void deleteTeaColor(Long teaColorId) {

        TeaColor teaColor = teaColorRepository.getOne(teaColorId);
        teaColor.setDeleted(true);
        teaColorRepository.save(teaColor);
    }

    /**
     * Удаление элементов типа чая
     */
    public void deleteTeaType(Long teaTypeId) {

        TeaType teaType = teaTypeRepository.getOne(teaTypeId);
        teaType.setDeleted(true);
        teaTypeRepository.save(teaType);
    }

    /**
     * Получение списка стран
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findCountries() {
        return catalogMapper.catalogsToCatalogsDTO(countriesRepository.findAll(Sort.by("name").ascending()));
    }

    /**
     * Получение списка производителей
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findManufacturers() {
        return catalogMapper.catalogsToCatalogsDTO(manufacturerRepository.findAll(Sort.by("name").ascending()));
    }

    /**
     * Получение списка обжарки
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findRoastings() {
        return catalogMapper.catalogsToCatalogsDTO(roastingRepository.findAll(Sort.by("name").ascending()));
    }

    /**
     * Получение списка упаковок
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findPackages() {
        return catalogMapper.catalogsToCatalogsDTO(packagingRepository.findAll(Sort.by("name").ascending()));
    }

    /**
     * Получение списка цвета чая
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findTeaColors() {
        return catalogMapper.catalogsToCatalogsDTO(teaColorRepository.findAll(Sort.by("name").ascending()));
    }

    /**
     * Получение списка типов кофе
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findCoffeeTypes() {
        return catalogMapper.catalogsToCatalogsDTO(coffeeTypeRepository.findAll(Sort.by("name").ascending()));
    }

    /**
     * Получение списка типов чая
     *
     * @return List<GeneralCatalogDTO>
     */
    public List<GeneralCatalogDTO> findTeaTypes() {
        return catalogMapper.catalogsToCatalogsDTO(teaTypeRepository.findAll(Sort.by("name").ascending()));
    }
}