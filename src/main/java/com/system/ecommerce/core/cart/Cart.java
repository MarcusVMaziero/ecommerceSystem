package com.system.ecommerce.core.cart;

import com.system.ecommerce.core.product.Product;
import com.system.ecommerce.data.cart.CartModel;
import com.system.ecommerce.rest.request.CartRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {

    private Long id;
    private String email;
    private Integer ammount;
    private Long idProduct;
    private List<Product> productList;

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
                .email(cartModel.getEmail())
                .build();
    }

    public static Cart toCheckout(CartModel cartModel) {
        return Cart.builder()
                .id(cartModel.getId())
                .email(cartModel.getEmail())
                .productList(cartModel.getProductModelList()
                        .stream().map(Product::toProductCheckout)
                        .collect(Collectors.toList()))
                .build();
    }

    public static Product toServiceCartAddProduct(Product product, Cart cart) {
        return Product.builder()
                .code(product.getCode())
                .name(product.getName())
                .value(product.getValue())
                .idCart(cart.getId())
                .ammout(cart.getAmmount())
                .build();
    }
}
