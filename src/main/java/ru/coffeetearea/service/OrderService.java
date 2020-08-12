package ru.coffeetearea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coffeetearea.dto.CartItemDTO;
import ru.coffeetearea.dto.OrderDTO;
import ru.coffeetearea.model.CartItem;
import ru.coffeetearea.model.Order;
import ru.coffeetearea.model.OrderStatus;
import ru.coffeetearea.model.User;
import ru.coffeetearea.repository.DrinkRepository;
import ru.coffeetearea.repository.OrderRepository;
import ru.coffeetearea.repository.UserRepository;
import ru.coffeetearea.security.JwtUserDetailsService;
import ru.coffeetearea.security.jwt.JwtUser;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    // Поля

    private final DrinkRepository drinkRepository;

    private final UserRepository userRepository;

    private final CartItemService cartItemService;

    private final OrderRepository orderRepository;

    private final JwtUserDetailsService jwtUserDetailsService;

    //

//    public Order addDrinksToOrder(List<CartItemDTO> cartItemsDTO){
//
//        User user = JwtUser.getCurrentUser();
//
//        Order order = new Order();
//        order.setOrderStatus(OrderStatus.NEW);
//
//        List<CartItem> cartItems = new ArrayList<>();
//
//        for (CartItemDTO c : cartItemsDTO) {
//
//            cartItems.add(cartItemService.addCartItem(c));
//        }
//
//        order.setCartItem(cartItems);
//        order.setOrderStatus(OrderStatus.NEW);
//
//        return userRepository.save(user.set);
//    }



    public Order makeOrder(Long orderId, OrderDTO orderDTO){

        Order order = orderRepository.getOne(orderId);

        order.setAddress(orderDTO.getAddress());
        order.setPhoneNumber(orderDTO.getPhoneNumber());
        order.setDateOrder(orderDTO.getDateOrder());
        order.setOrderStatus(OrderStatus.ACTIVE);

        return orderRepository.save(order);
    }
}