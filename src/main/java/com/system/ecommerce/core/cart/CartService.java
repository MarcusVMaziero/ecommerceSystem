package com.system.ecommerce.core.cart;

import com.system.ecommerce.core.product.Product;
import com.system.ecommerce.core.product.ProductService;
import com.system.ecommerce.data.cart.CartGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@RequiredArgsConstructor
@Component
public class CartService {

    private final CartGateway cartGateway;
    private final ProductService productService;

    public Cart create(Cart cart) {
        Cart cartExist = cartGateway.findCartEmail(cart.getEmail());
        if (cartExist != null) {
            cart.setId(cartExist.getId());
            productService.addProductToCart(cart);
            return cart;
        } else {
            var cartNew = cartGateway.create(cart);
            cartNew.setAmmount(cart.getAmmount());
            cartNew.setIdProduct(cart.getIdProduct());
            productService.addProductToCart(cartNew);
            return cartNew;
        }
    }

    public CartCheckout checkout(CartCheckout cartCheckout) {
        var products = new ArrayList<>(cartGateway.findCartCheckout(cartCheckout).getProductList());
        var counts = products.stream().map(Product::getValue).collect(Collectors.toList());
        Double totalValue = counts.stream()
                .flatMapToDouble(DoubleStream::of)
                .sum();
        cartCheckout.toCartCheckout(products, totalValue);
        return cartCheckout;
    }
}
