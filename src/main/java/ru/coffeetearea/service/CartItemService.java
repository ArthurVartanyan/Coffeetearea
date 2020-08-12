package ru.coffeetearea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coffeetearea.dto.CartItemDTO;
import ru.coffeetearea.exceptions.EntityNotFoundException;
import ru.coffeetearea.model.CartItem;
import ru.coffeetearea.repository.DrinkRepository;
import ru.coffeetearea.repository.CartItemRepository;

@Service
@RequiredArgsConstructor
public class CartItemService {

    // Поля

    private final CartItemRepository cartItemRepository;

    private final DrinkRepository drinkRepository;

    //

    /**
     * Добавление 1 товара в корзину(1 шт.).
     * Данный метод используется тогда,
     * когда мы добавляем товары в корзину,
     * находясь при этом на страницы простмотра всех товаров(при выгрузке товаров по фильтру или параметрам);
     * То есть, если мы находимся на странице просмотра содержимого корзины,
     * то этот метод там не используется!
     * @param drinkId
     * @return Элемент корзины с напитком и его дефолтным количеством 1.
     */
    public CartItem addDrinkInCart(Long drinkId) {
        // Если товара под таким ИД нет в базе, то выдаем ошибку собственного производства!
        if (!drinkRepository.existsById(drinkId)) {

            throw new EntityNotFoundException(drinkId);
        } else {
            // Если же товар есть, мы создаем экземпляр и работаем с ним.
            CartItem cartItem = new CartItem();

            cartItem.setDrink(drinkRepository.getById(drinkId));
            cartItem.setCount(1); // По дефолту кол-во 1
            return cartItemRepository.save(cartItem);
        }
    }


    /**
     * Удаление товара из корзины
     * @param drinkId
     */
    public CartItem removeDrinkFromCart(Long drinkId){

        if (!cartItemRepository.existsById(drinkId)) {

            throw new EntityNotFoundException(drinkId);
        } else {

            return cartItemRepository.removeByDrinkId(drinkId);
        }
    }


//    public CartItem addCartItem(CartItemDTO cartItemDTO) {
//
//        if (!drinkRepository.existsById(cartItemDTO.getDrink().getId())) {
//
//            throw new EntityNotFoundException(cartItemDTO.getDrink().getId());
//        } else {
//
//            CartItem cartItem = new CartItem();
//
//            cartItem.setDrink(drinkRepository.getById(cartItemDTO.getDrink().getId()));
//            cartItem.setCount(cartItemDTO.getCount());
//
//            return cartItemRepository.save(cartItem);
//        }
//    }
}