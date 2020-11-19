package ru.coffeetearea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coffeetearea.dto.MakeOrderDTO;
import ru.coffeetearea.dto.OrderDTO;
import ru.coffeetearea.dto.OrderInfoDTO;
import ru.coffeetearea.exceptions.EntityNotFoundException;
import ru.coffeetearea.exceptions.InternalServerException;
import ru.coffeetearea.mappers.OrderMapper;
import ru.coffeetearea.model.CartItem;
import ru.coffeetearea.model.Order;
import ru.coffeetearea.model.OrderStatus;
//import ru.coffeetearea.repository.AddressRepository;
import ru.coffeetearea.repository.OrderRepository;
import ru.coffeetearea.security.jwt.JwtUser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    // Поля

    private final OrderRepository orderRepository;

//    private final AddressRepository addressRepository;

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
        cartItemList.forEach(c ->
                priceOfCartItem.add(c.getDrink().getPrice().multiply(new BigDecimal(c.getCount()))));

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
     * @param makeOrderDTO
     * @return saved order
     */
    public OrderDTO makeOrder(MakeOrderDTO makeOrderDTO) {

        Long userId = JwtUser.getCurrentUserID();

        Order order = orderRepository.findByUserIdAndOrderStatus(userId, OrderStatus.NEW);

        if (order == null) {
            throw new InternalServerException("Ошибка! Ваша корзина пуста!");
        }
        order.setTotalCost(calculateOrderPrice(order));
//        order.setAddress(makeOrderDTO.getAddress());
        Order.Address address = order.new Address();
//        address.setRegion();
        order.setPhoneNumber(makeOrderDTO.getPhoneNumber());
        order.setDateOrder(new Date());
        order.setOrderStatus(OrderStatus.ACTIVE);

//        addressRepository.save(order.getAddress());

        orderRepository.save(order);

        return orderMapper.orderToOrderDTO(order);
    }


    /**
     * Найти заказ по номеру(ИД)
     *
     * @param orderId
     * @return
     */
    public OrderInfoDTO findOrder(Long orderId) {

        Order order = orderRepository.findById(orderId).orElseThrow(() -> new EntityNotFoundException(orderId));

        return orderMapper.orderToOrderInfoDTO(order);
    }


    /**
     * Отменить заказ
     *
     * @param orderId
     * @return OrderInfoDTO
     */
    public OrderInfoDTO cancelOrder(Long orderId) {

        Order order = orderRepository.getOne(orderId);

        order.setOrderStatus(OrderStatus.CANCELED);

        orderRepository.save(order);

        return orderMapper.orderToOrderInfoDTO(order);
    }


    /**
     * Отменить заказ
     *
     * @param orderId
     * @return OrderInfoDTO
     */
    public OrderInfoDTO completeOrder(Long orderId) {

        Order order = orderRepository.getOne(orderId);

        order.setOrderStatus(OrderStatus.COMPLETED);

        orderRepository.save(order);

        return orderMapper.orderToOrderInfoDTO(order);
    }


    /**
     * Посмотреть все заказы пользователя(пользователь)
     *
     * @return OrderInfoDTO
     */
    public List<OrderInfoDTO> userOrders() {

        List<Order> userOrders = orderRepository.findAllByUserId(JwtUser.getCurrentUserID());

        return orderMapper.ordersToOrdersInfoDTO(userOrders);
    }
}