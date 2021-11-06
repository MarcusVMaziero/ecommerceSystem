package com.system.ecommerce.data.cart;

import com.system.ecommerce.core.cart.Cart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartModel {

    @Id
    @GeneratedValue
    private Long id;

    @GeneratedValue
    private Long idCartCustomer;

    private String email;

    private Integer ammount;

    private Long idProduct;

    public static CartModel toModel(Cart cart) {
        return CartModel.builder()
                .id(cart.getId())
                .email(cart.getEmail())
                .ammount(cart.getAmmount())
                .idProduct(cart.getIdProduct())
                .build();
    }
}
