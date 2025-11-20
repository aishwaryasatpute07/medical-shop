package com.medicalshop.medical_shop_project.repository;

import com.medicalshop.medical_shop_project.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    // All items in a customer's cart
    List<Cart> findByCustomerId(Long customerId);

    // Check if same medicine already in cart for upsert behavior
    @Query("SELECT c FROM Cart c WHERE c.customerId = :customerId AND c.medicine.id = :medicineId")
    Optional<Cart> findByCustomerAndMedicine(@Param("customerId") Long customerId,
                                             @Param("medicineId") Long medicineId);

}
