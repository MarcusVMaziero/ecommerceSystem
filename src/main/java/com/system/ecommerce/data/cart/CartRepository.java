package com.system.ecommerce.data.cart;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartModel, Long> {

    List<CartModel> findByEmailContainingAndStatus(String email, boolean status);
}
