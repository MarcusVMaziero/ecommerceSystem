package com.system.ecommerce.data.cart;

import com.system.ecommerce.core.cart.Cart;

import java.util.List;

public interface CartGateway {

    Cart create(Cart cart);

    List<Cart> findCartEmail(String email);

    Cart findCart(Cart cart);
}
