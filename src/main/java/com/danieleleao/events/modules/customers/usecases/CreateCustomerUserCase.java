package com.danieleleao.events.modules.customers.usecases;

import com.danieleleao.events.modules.customers.entities.Customer;
import com.danieleleao.events.modules.customers.repository.ICustomerRepository;
import com.danieleleao.events.shared.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerUserCase {


    @Autowired
    private ICustomerRepository customerRepository;



    public Customer execute(Customer customer) {
        // Validar email

        var customerExists = this.customerRepository.findByEmail(customer.getEmail());
        if(customerExists != null) {
            throw new CustomException("Customer already exists", HttpStatus.CONFLICT);
        }
        var customerCreated = this.customerRepository.save(customer);
        return customerCreated;

    }
}
