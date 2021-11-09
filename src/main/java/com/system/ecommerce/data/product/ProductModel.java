package com.system.ecommerce.data.product;

import com.system.ecommerce.core.product.Product;
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
public class ProductModel {

    @Id
    @GeneratedValue
    private Long id;
    private Long code;
    private String name;
    private Double value;
    private Integer ammout;
    private Long idCart;

    public static ProductModel toData(Product product) {
        return ProductModel.builder()
                .id(product.getId())
                .code(product.getCode())
                .name(product.getName())
                .value(product.getValue())
                .ammout(product.getAmmout())
                .idCart(product.getIdCart())
                .build();
    }
}
