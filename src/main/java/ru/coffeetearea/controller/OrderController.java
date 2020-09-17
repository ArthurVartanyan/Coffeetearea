package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffeetearea.dto.MakeOrderDTO;
import ru.coffeetearea.dto.OrderDTO;
import ru.coffeetearea.service.OrderService;

import javax.annotation.security.RolesAllowed;

import static ru.coffeetearea.model.Role.ROLE_CUSTOMER;

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
    @RolesAllowed({ROLE_CUSTOMER})
    @PostMapping
    public ResponseEntity<OrderDTO> makeOrder(@Validated @RequestBody MakeOrderDTO makeOrderDTO) {

        return new ResponseEntity<>(orderService.makeOrder(makeOrderDTO), HttpStatus.OK);
    }
}