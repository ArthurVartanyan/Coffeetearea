package ru.coffeetearea.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.coffeetearea.dto.MakeOrderDTO;
import ru.coffeetearea.dto.OrderDTO;
import ru.coffeetearea.model.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order orderForMakeOrder(MakeOrderDTO makeOrderDTO);

    OrderDTO orderToOrderDTO(Order order);

    Order orderDTOtoOrder(OrderDTO orderDTO);

    @IterableMapping(qualifiedByName = "ordersToOrdersDTO")
    List<OrderDTO> ordersToOrdersDTO(List<? extends Order> orders);
}