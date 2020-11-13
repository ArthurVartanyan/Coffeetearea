package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.coffeetearea.dto.MakeOrderDTO;
import ru.coffeetearea.dto.OrderDTO;
import ru.coffeetearea.dto.OrderInfoDTO;
import ru.coffeetearea.service.OrderService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

import static ru.coffeetearea.model.Role.ROLE_ADMIN;
import static ru.coffeetearea.model.Role.ROLE_CUSTOMER;

@RestController
@RequestMapping("/api/orders")
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


    // Put - methods

    /**
     * Оменить заказ
     *
     * @param orderId
     * @return OrderInfoDTO
     */
    @RolesAllowed({ROLE_ADMIN})
    @PutMapping("/{orderId}/cancellation")
    public OrderInfoDTO cancelOrder(@PathVariable Long orderId) {

        return orderService.cancelOrder(orderId);
    }


    /**
     * Оменить заказ
     *
     * @param orderId
     * @return OrderInfoDTO
     */
    @RolesAllowed({ROLE_ADMIN})
    @PutMapping("/{orderId}/readiness")
    public OrderInfoDTO completeOrder(@PathVariable Long orderId) {

        return orderService.completeOrder(orderId);
    }


    // Get - methods

    /**
     * Метод возвращает все заказы пользователя(со всеми статусами без исключения)
     *
     * @return List<OrderInfoDTO>
     */
    @RolesAllowed({ROLE_CUSTOMER})
    @GetMapping("/user-orders")
    public List<OrderInfoDTO> userOrders() {

        return orderService.userOrders();
    }


    /**
     * Найти заказ по ИД
     *
     * @param orderId
     * @return OrderInfoDTO
     */
    @RolesAllowed({ROLE_ADMIN})
    @GetMapping("/{orderId}")
    public OrderInfoDTO findOrder(@PathVariable Long orderId) {

        return orderService.findOrder(orderId);
    }
}