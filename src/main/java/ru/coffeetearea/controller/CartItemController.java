package ru.coffeetearea.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.coffeetearea.model.CartItem;
import ru.coffeetearea.service.CartItemService;


@RestController
@RequestMapping("/cart-item")
@RequiredArgsConstructor
@Api(value = "Cart item", tags = {"Cart item"})
public class CartItemController {

    private final CartItemService cartItemService;


    // Get - methods

    @PostMapping("/add-in-cart")
    private ResponseEntity<CartItem> addDrinkInCart(@RequestParam Long drinkId) {

        return new ResponseEntity<>(cartItemService.addDrinkInCart(drinkId), HttpStatus.CREATED);
    }


    // Delete - methods

    @DeleteMapping("/delete-from-cart")
    private ResponseEntity<CartItem> removeDrinkFromCart(@RequestParam Long drinkId) {

        return new ResponseEntity<>(cartItemService.removeDrinkFromCart(drinkId), HttpStatus.ACCEPTED);
    }
}