package com.system.ecommerce.rest.request;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.system.ecommerce.core.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest implements Serializable {

    @JsonProperty("productCode")
    private Long code;

    @JsonProperty("productName")
    private String name;

    @JsonProperty("productValue")
    private Double value;

}
