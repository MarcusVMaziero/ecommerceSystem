package com.system.ecommerce.data.product;

import com.system.ecommerce.core.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductData implements ProductGateway {

    private final ProductRepository productRepository;

    @Override
    public void create(Product product) {
        productRepository.save(ProductModel.toData(product));
    }

    @Override
    public List<Product> findProducts() {
        return productRepository.findByIdCart(null).stream()
                .map(Product::toService)
                .collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return Product.toService(Objects.requireNonNull(productRepository.findById(id).orElse(null)));
    }
}
