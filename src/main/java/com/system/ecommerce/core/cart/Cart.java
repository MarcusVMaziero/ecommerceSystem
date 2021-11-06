package com.system.ecommerce.core.cart;

import com.system.ecommerce.core.product.Product;
import com.system.ecommerce.data.cart.CartModel;
import com.system.ecommerce.rest.request.CartRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {

    private Long id;
    private Long idCartCustomer;
    private String email;
    private Integer ammount;
    private Long idProduct;

    public static Cart toService(CartRequest cartRequest) {
        return Cart.builder()
                .id(cartRequest.getId())
                .email(cartRequest.getEmail())
                .ammount(cartRequest.getAmmount())
                .idProduct(cartRequest.getIdProduct())
                .build();
    }

    public static Cart toService(CartModel cartModel) {
        return Cart.builder()
                .id(cartModel.getId())
                .idCartCustomer(cartModel.getIdCartCustomer())
                .email(cartModel.getEmail())
                .ammount(cartModel.getAmmount())
                .idProduct(cartModel.getIdProduct())
                .build();
    }
}
