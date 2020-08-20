package ru.coffeetearea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coffeetearea.dto.OrderDTO;
import ru.coffeetearea.mappers.OrderMapper;
import ru.coffeetearea.model.CartItem;
import ru.coffeetearea.model.Order;
import ru.coffeetearea.model.OrderStatus;
import ru.coffeetearea.repository.OrderRepository;
import ru.coffeetearea.security.jwt.JwtUser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    // Поля

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;
    //


    /**
     * Расчитать стоимость заказа
     *
     * @param order
     * @return расчитанная стомость
     */
    public BigDecimal calculateOrderPrice(Order order) {

        // Итоговая цена BigDecimal (изначально он равен нулю)
        BigDecimal totalPrice = new BigDecimal(0);

        // Создал коллекцию типа BigDecimal
        List<BigDecimal> priceOfCartItem = new ArrayList<>();

        // В этот список кидаю все элементы корзины заказа
        List<CartItem> cartItemList = order.getCartItems();

        // Пробегаемся по коллекции и умножаем кол-во напитков на стоимость напитка
        for (CartItem c : cartItemList) {

            priceOfCartItem.add(c.getDrink().getPrice().multiply(new BigDecimal(c.getCount())));
        }

        for (BigDecimal b : priceOfCartItem) {

            totalPrice = totalPrice.add(b);
        }
        return totalPrice;
    }


    /**
     * Сделать заказ.
     * По сути в этом методе заказ из статуса NEW переходит в статус ACTIVE,
     * соответственно, мы добавляем еще немного информации для заказа.
     *
     * @param orderDTO
     * @return saved order
     */
    public OrderDTO makeOrder(OrderDTO orderDTO) {

        Long userId = JwtUser.getCurrentUserID();

        Order order = orderRepository.findByUserIdAndOrderStatus(userId, OrderStatus.NEW);

        order.setTotalCost(calculateOrderPrice(order));
        order.setAddress(orderDTO.getAddress());
        order.setPhoneNumber(orderDTO.getPhoneNumber());
        order.setDateOrder(orderDTO.getDateOrder());
        order.setOrderStatus(OrderStatus.ACTIVE);

        orderRepository.save(order);

        return orderMapper.orderToOrderDTO(order);
    }
}