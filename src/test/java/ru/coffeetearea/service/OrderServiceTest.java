package ru.coffeetearea.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.coffeetearea.dto.MakeOrderDTO;
import ru.coffeetearea.dto.OrderDTO;
import ru.coffeetearea.mappers.OrderMapper;
import ru.coffeetearea.repository.OrderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceTest {

    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;




    @Test
    void makeOrder() {

        MakeOrderDTO makeOrderDTO = new MakeOrderDTO();

        OrderDTO orderDTO = orderService.makeOrder(makeOrderDTO);

        Assert.assertNotNull(orderDTO.getAddress());
        Assert.assertNotNull(orderDTO.getPhoneNumber());
    }
}