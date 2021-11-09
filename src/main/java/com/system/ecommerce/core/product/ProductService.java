package com.system.ecommerce.core.product;

import com.system.ecommerce.core.cart.Cart;
import com.system.ecommerce.data.product.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductService {

    private final ProductGateway productGateway;

    public List<Product> findProducts() {
        return productGateway.findProducts();
    }

    public void addProductToCart(Cart cart) {
        productGateway.create(Cart.toServiceCartAddProduct(productGateway.findById(cart.getIdProduct()), cart));
    }
}
