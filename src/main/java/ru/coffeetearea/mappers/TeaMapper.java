package ru.coffeetearea.mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import ru.coffeetearea.dto.TeaDTO;
import ru.coffeetearea.model.Tea;

@Mapper(componentModel = "spring")
public interface TeaMapper {

    TeaMapper INSTANCE = Mappers.getMapper(TeaMapper.class);

    TeaDTO teaToTeaDTO(Tea tea);

    Tea teaDTOtoTea(TeaDTO teaDTO);

    @IterableMapping(qualifiedByName = "teaToTeaDTO")
    default Page<TeaDTO> teaToTeasDTO(Page<Tea> teas) {
        return teas.map(this::teaToTeaDTO);
    }


//    @AfterMapping
//    public void calledWithSourceAndTarget(TeaDTO teaDTO, @MappingTarget Tea tea) {
//        // ...
//    }
}