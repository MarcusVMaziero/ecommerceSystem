package com.system.ecommerce.core.product;

import com.system.ecommerce.data.product.ProductData;
import com.system.ecommerce.data.product.ProductModel;
import com.system.ecommerce.rest.request.ProductRequest;
import com.system.ecommerce.rest.response.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private Long id;
    private Long code;
    private String name;
    private Double value;

    public static Product toService(ProductRequest productRequest) {
        return Product.builder()
                .code(productRequest.getCode())
                .name(productRequest.getName())
                .value(productRequest.getValue())
                .build();
    }

    public static Product toService(ProductModel productModel) {
        return Product.builder()
                .id(productModel.getId())
                .code(productModel.getCode())
                .name(productModel.getName())
                .value(productModel.getValue())
                .build();
    }
}
