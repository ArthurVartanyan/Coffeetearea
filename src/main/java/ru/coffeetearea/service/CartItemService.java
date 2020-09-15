package ru.coffeetearea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coffeetearea.dto.CartItemDTO;
import ru.coffeetearea.exceptions.EntityNotFoundException;
import ru.coffeetearea.exceptions.InternalServerException;
import ru.coffeetearea.mappers.CartItemMapper;
import ru.coffeetearea.model.CartItem;
import ru.coffeetearea.model.Drink;
import ru.coffeetearea.model.Order;
import ru.coffeetearea.model.OrderStatus;
import ru.coffeetearea.repository.CartItemRepository;
import ru.coffeetearea.repository.DrinkRepository;
import ru.coffeetearea.repository.OrderRepository;
import ru.coffeetearea.repository.UserRepository;
import ru.coffeetearea.security.jwt.JwtUser;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemService {

    // Поля

    private final CartItemRepository cartItemRepository;

    private final DrinkRepository drinkRepository;

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final CartItemMapper cartItemMapper;

    //

    /**
     * Добавление 1 товара в корзину(1 шт.).
     * Данный метод используется тогда,
     * когда мы добавляем товары в корзину,
     * находясь при этом на страницы простмотра всех товаров(при выгрузке товаров по фильтру или параметрам);
     * То есть, если мы находимся на странице просмотра содержимого корзины,
     * то этот метод там не используется!
     *
     * @param drinkId
     * @return Элемент корзины с напитком и его дефолтным количеством 1.
     */
    public CartItemDTO addDrinkInCart(Long drinkId) {

        // Беру ID залогиненного пользователя
        Long userId = JwtUser.getCurrentUserID();

        // Если товара под таким ИД нет в базе, то выдаем ошибку!
        if (!drinkRepository.existsById(drinkId)) {

            throw new EntityNotFoundException(drinkId);
        }

        Order userOrder = orderRepository.findByUserIdAndOrderStatus(userId, OrderStatus.NEW);

        // Проверяем, есть ли у пользователя уже заполненная корзина
        if (userOrder == null) {
            userOrder = new Order();
            userOrder.setOrderStatus(OrderStatus.NEW);
            userOrder.setUser(userRepository.getById(userId));

            orderRepository.save(userOrder); // Сохраняю заказ в БД
        }

        // Если товар уже в корзине, то его кол-во увеличивается на 1
        List<CartItem> cartItemList = userOrder.getCartItems();
        List<Drink> drinkList = new ArrayList<>();
        // Пробегаюсь по коллекции cartItemList и добавляю его напитки в drinkList
        cartItemList.forEach(c -> drinkList.add(c.getDrink()));

        if (drinkList.stream().anyMatch(drinkRepository.getById(drinkId)::equals)) {
            CartItem cartItem = cartItemRepository.getByOrderAndDrinkId(userOrder, drinkId);
            cartItem.setCount(cartItem.getCount() + 1);
            cartItemRepository.save(cartItem);
            return cartItemMapper.cartItemToCartItemDTO(cartItem);
        } else {
            // Если же товар есть, мы создаем экземпляр и работаем с ним.
            CartItem cart = new CartItem();
            cart.setDrink(drinkRepository.getById(drinkId));
            cart.setCount(1); // По дефолту кол-во 1

            cart.setOrder(userOrder);
            cart.setCartId(new CartItem.CartId(userOrder.getId(), drinkId));
            cartItemRepository.save(cart);

            return cartItemMapper.cartItemToCartItemDTO(cart);
        }
    }


    /**
     * Удаление товара из корзины.
     *
     * @param drinkId
     */
    public void removeDrinkFromCart(Long drinkId) {

        // Беру ID залогиненного пользователя
        Long userId = JwtUser.getCurrentUserID();

        // Мы берем уже имеющийся заказ, со статусом NEW у пользователя
        Order order = orderRepository.findByUserIdAndOrderStatus(userId, OrderStatus.NEW);

        if (order == null) {
            throw new EntityNotFoundException("Ошибка! Ваша корзина пуста!");
        }

        List<CartItem> cartItemList = order.getCartItems();

        cartItemList.remove(cartItemRepository.getByOrderAndDrinkId(order, drinkId));

        order.setCartItems(cartItemList);
        orderRepository.save(order);
    }


    /**
     * Удаление всех товаров из корзины.
     */
    public void removeAllDrinksFromCart() {

        // Беру ID залогиненного пользователя
        Long userId = JwtUser.getCurrentUserID();

        // Мы берем уже имеющийся заказ, со статусом NEW у пользователя
        Order order = orderRepository.findByUserIdAndOrderStatus(userId, OrderStatus.NEW);

        if (order == null) {
            throw new InternalServerException("Ошибка! Ваша корзина пуста!");
        }

        List<CartItem> cartItemList = order.getCartItems();

        cartItemList.clear();

        order.setCartItems(cartItemList);
        orderRepository.save(order);
    }


    /**
     * Получичение списка товаров в корзине
     */
    public List<CartItemDTO> showAllCartDrinks() {

        Long id = JwtUser.getCurrentUserID();

        Order order = orderRepository.findByUserIdAndOrderStatus(id, OrderStatus.NEW);

        if (order == null) {
            throw new InternalServerException("Ошибка! Ваша корзина пуста!");
        }

        List<CartItem> cartItem = order.getCartItems();

        return cartItemMapper.cartItemsToCartItemsDTO(cartItem);
    }


    /**
     * Изменение кол-ва напитка в корзине
     */
    public Integer editDrinkCount(Long drinkId, int count) {

        Order order = orderRepository.findByUserIdAndOrderStatus(JwtUser.getCurrentUserID(), OrderStatus.NEW);

        List<CartItem> cartItem = order.getCartItems();

        for (CartItem c : cartItem) {
            if (c.getDrink().equals(drinkRepository.getById(drinkId))) {
                c.setCount(count);
            }
        }
        order.setCartItems(cartItem);

        orderRepository.save(order);

        return count;
    }
}