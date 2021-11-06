package com.system.ecommerce.core.cart;

import com.system.ecommerce.core.product.ProductService;
import com.system.ecommerce.data.cart.CartGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@RequiredArgsConstructor
@Component
public class CartService {

    private final CartGateway cartGateway;
    private final ProductService productService;

    public Cart create(Cart cart) {

        if (cartGateway.findCartEmail(cart.getEmail()) == null) {
            var cartNew = cartGateway.create(cart);
            cartNew.setAmmount(cart.getAmmount());
            cartNew.setIdProduct(cart.getIdProduct());
            productService.addProductToCart(cartNew);
            return cartNew;
        } else {
            productService.addProductToCart(cart);
            return cart;
        }
    }

    public CartCheckout checkout(CartCheckout cartCheckout) {
        var products = new ArrayList<>(cartGateway.findCart(cartCheckout).getProductList());
        cartCheckout.toCartCheckout(products, 100.1);
        return cartCheckout;
    }
}
