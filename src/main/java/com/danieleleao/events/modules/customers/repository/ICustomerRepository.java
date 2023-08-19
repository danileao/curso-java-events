package com.danieleleao.events.modules.customers.repository;

import com.danieleleao.events.modules.customers.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICustomerRepository extends JpaRepository<Customer, UUID> {
     Customer findByEmail(String name);
}
