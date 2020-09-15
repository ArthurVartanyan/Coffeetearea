package ru.coffeetearea.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.coffeetearea.model.CartItem;
import ru.coffeetearea.model.Order;
import ru.coffeetearea.model.OrderStatus;
import ru.coffeetearea.repository.DrinkRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class OrderServiceTest {


    private OrderService orderService;

    private DrinkRepository drinkRepository;


    @Autowired
    public void setDrinkRepository(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }


    @Test
    void calculateOrderPrice() {

        Order order = new Order();

        order.setAddress("г.Воронеж, ул.Владимира Невского, дом 34В, кв. 101");
        order.setPhoneNumber("89805456785");
        order.setDateOrder(new Date());
        order.setOrderStatus(OrderStatus.NEW);

        CartItem cartItem = new CartItem();
        cartItem.setDrink(drinkRepository.getById(2L));
        cartItem.setCount(2);
        List<CartItem> cartItemList = new ArrayList<>();
        cartItemList.add(cartItem);

        order.setCartItems(cartItemList);

        // Проверка
        Assert.assertEquals(new BigDecimal(660), orderService.calculateOrderPrice(order));
    }
}