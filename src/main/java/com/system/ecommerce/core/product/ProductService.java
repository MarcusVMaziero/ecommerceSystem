package com.system.ecommerce.core.product;

import com.system.ecommerce.data.product.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductService {

    private final ProductGateway productGateway;

    public List<Product> findProducts(){
        return productGateway.findProducts();
    }

    public List<Product> findProducts(List<Long> idsProduct) {
        return productGateway.findAllById(idsProduct);
    }
}
