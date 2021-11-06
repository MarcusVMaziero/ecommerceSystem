package com.system.ecommerce.data.cart;

import com.system.ecommerce.core.cart.Cart;
import com.system.ecommerce.core.cart.CartCheckout;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartData implements CartGateway {

    private final CartRepository cartRepository;

    @Override
    public Cart create(Cart cart) {
        return Cart.toService(
                cartRepository.save(
                        CartModel.toModel(cart)
                ));
    }

    @Override
    public Cart findCartEmail(String email) {
        return cartRepository.findByEmailContainingAndStatus(email, false)
                .stream().findFirst().map(Cart::toService).orElse(null);
    }

    @Override
    public Cart findCart(CartCheckout cartCheckout) {
        CartModel cartModel = cartRepository.findById(cartCheckout.getId()).get();
        return Cart.toService(cartModel);
    }
}
