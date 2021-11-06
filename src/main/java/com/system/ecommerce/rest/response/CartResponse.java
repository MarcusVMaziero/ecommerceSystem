package com.system.ecommerce.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.system.ecommerce.core.cart.Cart;
import com.system.ecommerce.core.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartResponse {

    @JsonProperty("idCart")
    private Long id;

    @JsonProperty("emailCustomer")
    private String email;

    @JsonProperty("ammountProduct")
    private Integer ammount;

    @JsonProperty("idProduct")
    private Long idProduct;

    @JsonProperty("productList")
    private List<Product> productList;

    public static CartResponse toResponse(Cart cart) {
        return CartResponse.builder()
                .id(cart.getId())
                .email(cart.getEmail())
                .ammount(cart.getAmmount())
                .build();
    }
}
