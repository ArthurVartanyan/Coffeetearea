package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffeetearea.dto.OrderDTO;
import ru.coffeetearea.service.OrderService;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Api(value = "Order", tags = {"Order"})
public class OrderController {

    private final OrderService orderService;


    // Post - methods

    /**
     * Оформление заказа
     *
     * @param orderDTO
     */
    @PostMapping("/make-order")
    public OrderDTO makeOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.makeOrder(orderDTO);
    }
}