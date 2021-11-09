package com.system.ecommerce.data.cart;

import com.system.ecommerce.core.cart.Cart;
import com.system.ecommerce.core.cart.CartCheckout;

public interface CartGateway {

    Cart create(Cart cart);

    Cart findCartEmail(String email);

    Cart findCartCheckout(CartCheckout cartCheckout);
}
