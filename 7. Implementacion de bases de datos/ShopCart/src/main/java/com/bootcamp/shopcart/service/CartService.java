package com.bootcamp.shopcart.service;

import com.bootcamp.shopcart.dto.CartRequestBody;
import com.bootcamp.shopcart.dto.CartResponseBody;
import com.bootcamp.shopcart.model.Cart;
import com.bootcamp.shopcart.model.Item;
import com.bootcamp.shopcart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public CartResponseBody saveCart(CartRequestBody request) {
        List<Item> items = request
                .items()
                .stream()
                .map(entry ->
                        Item
                                .builder()
                                .name(entry.name())
                                .build())
                .toList();

        Cart cart = Cart
                .builder()
                .items(items)
                .build();

        cartRepository.save(cart);

        return new CartResponseBody(cart.getId(), request.items());

    }
}
