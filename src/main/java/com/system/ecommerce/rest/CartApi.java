package com.system.ecommerce.rest;

import com.system.ecommerce.core.cart.Cart;
import com.system.ecommerce.core.cart.CartService;
import com.system.ecommerce.rest.request.CartRequest;
import com.system.ecommerce.rest.response.CartResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart/v1")
@RequiredArgsConstructor
public class CartApi {

    private final CartService cartService;

    @PostMapping
    public CartResponse postCart(@RequestBody CartRequest cartRequest) {
        return CartResponse.toResponse(
                cartService.create(Cart.toService(cartRequest))
        );
    }
}
