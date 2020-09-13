package ru.coffeetearea.service;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import ru.coffeetearea.dto.DrinkDTO;
import ru.coffeetearea.dto.SortingParams;
import ru.coffeetearea.exceptions.BadRequestException;
import ru.coffeetearea.exceptions.EntityNotFoundException;
import ru.coffeetearea.mappers.DrinkMapper;
import ru.coffeetearea.model.Drink;
import ru.coffeetearea.model.User;
import ru.coffeetearea.repository.CartItemRepository;
import ru.coffeetearea.repository.DrinkRepository;
import ru.coffeetearea.repository.UserRepository;
import ru.coffeetearea.security.jwt.JwtUser;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkService {

    // Fields

    @Value("${upload.path}")
    private String uploadPath;

    private final DrinkRepository drinkRepository;

    private final UserRepository userRepository;

    private final DrinkMapper drinkMapper;

    private final CartItemRepository cartItemRepository;

    //


    /**
     * Получить изображение напитка
     *
     * @param response
     * @param drinkId
     * @throws IOException
     */
    public void putDrinkImage(HttpServletResponse response, Long drinkId) throws IOException {

        String imageURL = drinkRepository.getById(drinkId).getImage();

        InputStream in = new FileInputStream(uploadPath + imageURL);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }


    /**
     * Удалить напиток из избранного
     *
     * @param drinkId
     */
    public void deleteDrinkFromFavourites(Long drinkId) {

        User user = userRepository.getById(JwtUser.getCurrentUserID());
        // Берем у пользователя избранные напитки
        List<Drink> favouriteDrinks = user.getFavouriteDrinks();

        if (favouriteDrinks.contains(drinkRepository.getById(drinkId))) {

            favouriteDrinks.remove(drinkRepository.getById(drinkId));
            // Equals переопределен в Drink
            favouriteDrinks.removeIf(e -> e.equals(drinkRepository.getById(drinkId)));
            // Сохраняем коллекцию обратно к пользователю
            user.setFavouriteDrinks(favouriteDrinks);
            // Сохраняем пользователя с напитками
            userRepository.save(user);
        } else {
            throw new EntityNotFoundException("Ошибка! Данного напитка у Вас нет в избранных!");
        }

    }


    /**
     * Посмотреть напитки в избранном
     */
    public List<DrinkDTO> findFavouriteDrinks() {

        // Ищем польователя по ИД
        User user = userRepository.getById(JwtUser.getCurrentUserID());
        // Создаем список и присваиваем ему все избранные напитки
        List<Drink> drinkList = user.getFavouriteDrinks();

        if (drinkList.isEmpty()) {
            throw new EntityNotFoundException("Ошибка! У Вас нет избранных напитков!");
        }
        // Возврашаем ДТО списка напитков
        return drinkMapper.drinksToDrinksDTO(drinkList);
    }


    /**
     * Добавить напиток в избранное
     *
     * @param drinkId
     * @return DrinkDTO добавленный в избранное
     */
    public Long addDrinkInFavourites(Long drinkId) {

        Drink drink = drinkRepository.findById(drinkId)
                .orElseThrow(() -> new EntityNotFoundException(drinkId));

        User user = userRepository.getById(JwtUser.getCurrentUserID());

        List<Drink> userFavouriteList = user.getFavouriteDrinks();

        if (userFavouriteList.contains(drinkRepository.getById(drinkId))) {
            throw new BadRequestException("Внимание! Данный напиток уже добавлен в изюранное!");
        }

        userFavouriteList.add(drink);

        user.setFavouriteDrinks(userFavouriteList);

        userRepository.save(user);

        return drinkId;
    }


    /**
     * Получение списка самых популярных товаров
     *
     * @return drinksDTOs
     */
    public List<DrinkDTO> findMostPopularDrinks() {

        List<Long> drinksIds = cartItemRepository.getMostPopularDrinksIds(PageRequest.of(0, 6));

        List<Drink> drinks = new ArrayList<>();

        // Добавляем в коллекцию элементы по ИД, и если элемент отсутствует, то выдаем ошибку
        drinksIds.forEach(d -> drinks
                .add(drinkRepository
                        .findById(d)
                        .orElseThrow(() -> new EntityNotFoundException(d))));

        // От 0 до 6, так как в sublist элемент i1 не включает в себя конечный элемент([0, 6))
        return drinkMapper.drinksToDrinksDTO(drinks);
    }


    /**
     * Сортировка напитков на страничках.
     * Она применяется в классе CoffeeService и TeaService.
     * Сюда вынесена, чтобы не повторять один и тот же код.
     *
     * @param sortingParams
     * @param page
     * @param pageSize
     * @return PageRequest
     */
    public PageRequest sortingWithParams(SortingParams sortingParams, int page, int pageSize) {

        switch (sortingParams) {

            case PRICE_INCREASE:
                return PageRequest.of(page, pageSize, Sort.by("price").ascending());

            case PRICE_DECREASE:
                return PageRequest.of(page, pageSize, Sort.by("price").descending());

            case NAME_INCREASE:
                return PageRequest.of(page, pageSize, Sort.by("name").ascending());

            case POP_DECREASE:
                return PageRequest.of(page, pageSize, Sort.by("drinkCountInOrder").descending());

            default:
                return PageRequest.of(page, pageSize, Sort.unsorted());
        }
    }
}