package ru.coffeetearea.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.coffeetearea.dto.MakeOrderDTO;
import ru.coffeetearea.dto.OrderDTO;
import ru.coffeetearea.dto.OrderInfoDTO;
import ru.coffeetearea.model.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    /**
     * MakeOrder - в отличие от остальных мапперов он для метода(конкретного)
     * @param makeOrderDTO
     * @return
     */
    Order orderForMakeOrder(MakeOrderDTO makeOrderDTO);

    /**
     * Order
     * @param order
     * @return
     */
    OrderDTO orderToOrderDTO(Order order);

    /**
     * Order
     * @param orderDTO
     * @return
     */
    Order orderDTOtoOrder(OrderDTO orderDTO);

    /**
     * Order
     * @param orders
     * @return
     */
    @IterableMapping(qualifiedByName = "ordersToOrdersDTO")
    List<OrderDTO> ordersToOrdersDTO(List<? extends Order> orders);

    /**
     * OrderInfoDTO
     * @param order
     * @return
     */
    @Mapping(source = "order.user", target = "userDTO")
    OrderInfoDTO orderToOrderInfoDTO(Order order);
}