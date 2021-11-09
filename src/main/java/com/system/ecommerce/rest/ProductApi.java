package com.system.ecommerce.rest;

import com.system.ecommerce.core.product.ProductService;
import com.system.ecommerce.queue.ProductMQProducer;
import com.system.ecommerce.rest.request.ProductRequest;
import com.system.ecommerce.rest.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product/v1")
@RequiredArgsConstructor
public class ProductApi {

    private final ProductService productService;
    private final ProductMQProducer productMQProducer;

    @GetMapping("products")
    public List<ProductResponse> getProducts() {
        return productService.findProducts().stream()
                .map(ProductResponse::toResponse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void postProduct(@RequestBody ProductRequest productRequest) {
        productMQProducer.send(productRequest);
    }
}
