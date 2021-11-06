package com.system.ecommerce.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.system.ecommerce.core.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    @JsonProperty("productId")
    private Long id;

    @JsonProperty("productCode")
    private Long code;

    @JsonProperty("productName")
    private String name;

    @JsonProperty("productValue")
    private Double value;

    public static ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .code(product.getCode())
                .name(product.getName())
                .value(product.getValue())
                .build();
    }
}
