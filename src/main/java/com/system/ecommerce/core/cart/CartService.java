package com.system.ecommerce.core.cart;

import com.system.ecommerce.core.product.ProductService;
import com.system.ecommerce.data.cart.CartGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CartService {

    private final CartGateway cartGateway;
    private final ProductService productService;

    public Cart create(Cart cart) {
        var cartsActual = cartGateway.findCartEmail(cart.getEmail());
        if (cartsActual.isEmpty()) {
            return cartGateway.create(cart);
        }
        cart.setIdCartCustomer(cartsActual.stream().findFirst().get().getIdCartCustomer());
        return cartGateway.create(cart);
    }
}
