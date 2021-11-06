package com.system.ecommerce.rest.response;

import com.system.ecommerce.core.cart.CartCheckout;
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
public class CheckoutResponse {

    private Long id;
    private String email;
    private Double totalValue;
    private List<Product> productList;

    public static CheckoutResponse toResponse(CartCheckout cartCheckout) {
        return CheckoutResponse.builder()
                .id(cartCheckout.getId())
                .email(cartCheckout.getEmail())
                .productList(cartCheckout.getProductList())
                .totalValue(cartCheckout.getTotalValue())
                .build();
    }
}
