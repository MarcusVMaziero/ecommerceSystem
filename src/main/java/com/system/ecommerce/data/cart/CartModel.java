package com.system.ecommerce.data.cart;

import com.system.ecommerce.core.cart.Cart;
import com.system.ecommerce.data.product.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartModel {

    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private boolean status;

    @OneToMany
    @JoinColumn(name = "idCart")
    private List<ProductModel> productModelList;

    public static CartModel toModel(Cart cart) {
        return CartModel.builder()
                .id(cart.getId())
                .email(cart.getEmail())
                .build();
    }
}
