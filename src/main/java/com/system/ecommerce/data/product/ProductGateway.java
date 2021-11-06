package com.system.ecommerce.data.product;

import com.system.ecommerce.core.product.Product;

import java.util.List;

public interface ProductGateway {

    void create(Product product);

    List<Product> findProducts();

    Product findById(Long id);
}
