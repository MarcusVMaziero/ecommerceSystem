package com.system.ecommerce.rest;

import com.system.ecommerce.core.cart.Cart;
import com.system.ecommerce.core.cart.CartCheckout;
import com.system.ecommerce.core.cart.CartService;
import com.system.ecommerce.rest.request.CartRequest;
import com.system.ecommerce.rest.request.CheckoutRequest;
import com.system.ecommerce.rest.response.CartResponse;
import com.system.ecommerce.rest.response.CheckoutResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart/v1")
@RequiredArgsConstructor
public class CartApi {

    private final CartService cartService;

    @PostMapping
    public CartResponse addProductToCart(@RequestBody CartRequest cartRequest) {
        return CartResponse.toResponse(
                cartService.create(Cart.toService(cartRequest)));
    }

    @PatchMapping("checkout")
    public CheckoutResponse getCheckout(@RequestBody CheckoutRequest checkoutRequest) {
        return CheckoutResponse.toResponse(cartService.checkout(CartCheckout.toService(checkoutRequest)));
    }
}
