package ru.coffeetearea.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.coffeetearea.dto.CartItemDTO;
import ru.coffeetearea.model.CartItem;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartItemMapper {

    CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);

    CartItemDTO cartItemToCartItemDTO(CartItem cartItem);

    CartItem cartItemDTOtoCartItem(CartItemDTO cartItemDTO);

    @IterableMapping(qualifiedByName = "cartItemsToCartItemsDTO")
    List<CartItemDTO> cartItemsToCartItemsDTO(List<? extends CartItem> cartItems);


    /**
     * Маппер для CartItemPrice
     */

}