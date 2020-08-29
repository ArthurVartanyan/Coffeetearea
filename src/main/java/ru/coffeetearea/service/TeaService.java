package ru.coffeetearea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.coffeetearea.dto.PageDTO;
import ru.coffeetearea.dto.SortingParams;
import ru.coffeetearea.dto.TeaDTO;
import ru.coffeetearea.exceptions.EntityNotFoundException;
import ru.coffeetearea.mappers.TeaMapper;
import ru.coffeetearea.model.Tea;
import ru.coffeetearea.repository.TeaRepository;
import ru.coffeetearea.specification.DrinksSpecification;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TeaService {

    // Fields

    private final TeaRepository teaRepository;

    private final TeaMapper teaMapper;

    private final DrinkService drinkService;


    /**
     * Редктирование напитка чая
     *
     * @param teaId
     * @param teaDTO
     * @return teaDTO
     */
    public TeaDTO editTea(Long teaId, TeaDTO teaDTO) {

        Tea tea = teaRepository
                .findById(teaId)
                .orElseThrow(() -> new EntityNotFoundException(teaId));

        if (teaDTO.getName() != null) tea.setName(teaDTO.getName());
        if (teaDTO.getPrice() != null) tea.setPrice(teaDTO.getPrice());
        if (teaDTO.getAbout() != null) tea.setAbout(teaDTO.getAbout());
        if (teaDTO.getPackaging() != null) tea.setPackaging(teaMapper.teaDTOtoTea(teaDTO).getPackaging());
        if (teaDTO.getManufacturer() != null) tea.setManufacturer(teaMapper.teaDTOtoTea(teaDTO).getManufacturer());
        if (teaDTO.getCountry() != null) tea.setCountry(teaMapper.teaDTOtoTea(teaDTO).getCountry());
        if (teaDTO.getWeight() == 0) tea.setWeight(teaDTO.getWeight());
        if (teaDTO.getTeaType() != null) tea.setTeaType(teaDTO.getTeaType());
        if (teaDTO.getTeaColor() != null) tea.setTeaColor(teaDTO.getTeaColor());

        teaRepository.save(tea);

        return teaMapper.teaToTeaDTO(tea);
    }


    /**
     * Удалить чай из списка товаров.
     * На самом деле меняем всего лишь поле is_deleted.
     */
    public void deleteTeaFromDrinks(Long teaId) {

        Tea tea = teaRepository.findById(teaId).orElseThrow(() -> new EntityNotFoundException(teaId));

        tea.setDeleted(true);

        teaRepository.save(tea);
    }


    /**
     * Добавить новый чай в список товаров
     *
     * @param teaDTO
     * @return
     */
    public TeaDTO addTea(TeaDTO teaDTO) {

        Tea tea = new Tea();

        tea.setName(teaDTO.getName());
        tea.setPrice(teaDTO.getPrice());
        tea.setAbout(teaDTO.getAbout());
        tea.setPackaging(teaMapper.teaDTOtoTea(teaDTO).getPackaging());
        tea.setManufacturer(teaMapper.teaDTOtoTea(teaDTO).getManufacturer());
        tea.setCountry(teaMapper.teaDTOtoTea(teaDTO).getCountry());
        tea.setWeight(teaDTO.getWeight());
        tea.setTeaType(teaDTO.getTeaType());
        tea.setTeaColor(teaDTO.getTeaColor());
        tea.setDeleted(false);
        teaRepository.save(tea);

        return teaMapper.teaToTeaDTO(tea);
    }

    /**
     * Метод для вывода всего чая
     *
     * @param page
     * @param pageSize
     * @return CoffeesDTOs
     */
    public PageDTO<TeaDTO> findAll(int page, int pageSize, SortingParams sortingParams) {

        final Page<Tea> teas = teaRepository.findAll(drinkService.sortingWithParams(sortingParams, page, pageSize));

        return new PageDTO<>(teaMapper.teaToTeasDTO(teas));
    }


    /**
     * Метод для возвращение ЧАЯ через фильтрацию
     *
     * @param page
     * @param pageSize
     * @param colorId
     * @param typeId
     * @param countryId
     * @return filtered Coffees(DTOs)
     */
    public PageDTO<TeaDTO> findAllByFilter(int page, int pageSize, Long colorId, Long typeId, Long countryId,
                                           BigDecimal min, BigDecimal max, SortingParams sortingParams) {

        final Page<Tea> teas = teaRepository
                .findAll(DrinksSpecification
                                .getTeasByFilter(colorId, typeId, countryId, min, max),
                        drinkService.sortingWithParams(sortingParams, page, pageSize));

        return new PageDTO<>(teaMapper.teaToTeasDTO(teas));
    }
}