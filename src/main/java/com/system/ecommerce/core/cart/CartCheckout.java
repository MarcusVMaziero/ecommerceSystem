package com.system.ecommerce.core.cart;

import com.system.ecommerce.core.product.Product;
import com.system.ecommerce.rest.request.CheckoutRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartCheckout {

    private Long id;
    private String email;
    private Double totalValue;
    private List<Product> productList;

    public void toCartCheckout(List<Product> products, Double totalValue) {
        this.setProductList(products);
        this.setTotalValue(totalValue);
    }

    public static CartCheckout toService(CheckoutRequest checkoutRequest) {
        return CartCheckout.builder()
                .id(checkoutRequest.getId())
                .email(checkoutRequest.getEmail())
                .build();
    }
}
