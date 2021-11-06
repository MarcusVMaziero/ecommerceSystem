package com.system.ecommerce.data.cart;

import com.system.ecommerce.core.cart.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<Cart> findCartEmail(String email) {
        return cartRepository.findByEmailContaining(email).stream().map(Cart::toService)
                .collect(Collectors.toList());
    }

    @Override
    public Cart findCart(Cart cart) {
        CartModel cartModel = cartRepository.findById(cart.getId()).get();
        return Cart.toService(cartModel);
    }
}
