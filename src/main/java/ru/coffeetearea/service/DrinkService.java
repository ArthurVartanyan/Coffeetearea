package ru.coffeetearea.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coffeetearea.dto.DrinkDTO;
import ru.coffeetearea.mappers.DrinkMapper;
import ru.coffeetearea.model.Drink;
import ru.coffeetearea.model.User;
import ru.coffeetearea.repository.DrinkRepository;
import ru.coffeetearea.repository.UserRepository;
import ru.coffeetearea.security.jwt.JwtUser;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkService {

    // Fields

    private final DrinkRepository drinkRepository;

    private final UserRepository userRepository;

    private final DrinkMapper drinkMapper;
    //


    public void deleteDrinkFromFavourites(Long drinkId){

        User user = userRepository.getById(JwtUser.getCurrentUserID());

        List<Drink> favouriteDrinks =user.getFavouriteDrinks();

        favouriteDrinks.removeIf(e -> e.equals(drinkRepository.getById(drinkId)));

        user.setFavouriteDrinks(favouriteDrinks);

        userRepository.save(user);

//        favouriteDrinks.stream()..anyMatch(drinkRepository.getById(drinkId)::equals);
    }


    /**
     * Посмотреть напитки в избранном
     */
    public List<DrinkDTO> findFavouriteDrinks() {

        // Ищем польователя по ИД
        User user = userRepository.getById(JwtUser.getCurrentUserID());
        // Создаем список и присваиваем ему все избранные напитки
        List<Drink> drinkList = user.getFavouriteDrinks();
        // Возврашаем ДТО списка напитков
        return drinkMapper.drinksToDrinksDTO(drinkList);
    }


    /**
     * Добавить напиток в избранное
     *
     * @param drinkId
     * @return DrinkDTO добавленный в избранное
     */
    public DrinkDTO addDrinkInFavourites(Long drinkId) {

        Drink drink = drinkRepository.getById(drinkId);

        User user = userRepository.getById(JwtUser.getCurrentUserID());

        List<Drink> userFavouriteList = user.getFavouriteDrinks();

//        if (userFavouriteList.stream().filter(drink::equals).findFirst().get().equals(drink)) {
//
//            throw new RuntimeException("Напиток уже добавлен в избранное!");
//        }

        userFavouriteList.add(drink);

        user.setFavouriteDrinks(userFavouriteList);

        userRepository.save(user);

        return drinkMapper.drinkToDrinkDTO(drink);
    }


    /**
     * Получение списка товаров в корзине
     *
     * @param page
     * @param pageSize
     * @return drinksDTOs
     */
//    public PageDTO<DrinkDTO> findAllDrinks(int page, int pageSize) {
//
//        // Беру ID залогиненного пользователя
//        Long userId = JwtUser.getCurrentUser().getId();
//
//        Order order = orderRepository.findByUserIdAndOrderStatus(userId, OrderStatus.NEW);
//
//        List<CartItem> cartItemList = order.getCartItem();
//
//        List<Drink> drinkList = new ArrayList<>();
//
//        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("name"));
//
//
//        for (CartItem c : cartItemList) {
//            drinkList.add(c.getDrink());
//        }
//
//        final Page<Drink> drinks = drinkList;
//        return new PageDTO<DrinkDTO>(drinkMapper.drinksToDrinksDTO(drinks));
//    }
}