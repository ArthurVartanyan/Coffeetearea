package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.coffeetearea.dto.MakeOrderDTO;
import ru.coffeetearea.dto.OrderDTO;
import ru.coffeetearea.service.OrderService;

import javax.validation.constraints.Size;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Api(value = "Order", tags = {"Order"})
public class OrderController {

    private final OrderService orderService;


    // Post - methods

    /**
     * Оформление заказа
     *
     * @param makeOrderDTO
     */
    @PostMapping
    public ResponseEntity<OrderDTO> makeOrder(@Validated @RequestBody MakeOrderDTO makeOrderDTO) {
        return new ResponseEntity<>(orderService.makeOrder(makeOrderDTO), HttpStatus.OK);
    }
}