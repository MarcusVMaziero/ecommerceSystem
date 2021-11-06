package com.system.ecommerce.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartRequest {

    @JsonProperty("idCart")
    private Long id;

    @JsonProperty("emailCustomer")
    private String email;

    @JsonProperty("ammountProduct")
    private Integer ammount;

    @JsonProperty("idProduct")
    private Long idProduct;
}
