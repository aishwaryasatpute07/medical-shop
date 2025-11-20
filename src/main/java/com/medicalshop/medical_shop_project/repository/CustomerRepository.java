package com.medicalshop.medical_shop_project.repository;

import com.medicalshop.medical_shop_project.model.Customer;
import com.medicalshop.medical_shop_project.model.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<CustomerDTO> findByEmailAndPassword(String Email, String Password);
    Optional<CustomerDTO> findByEmail(String Email);
    boolean existsByEmail(String email);

}
