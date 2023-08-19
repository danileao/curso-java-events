package com.danieleleao.events.modules.customers.controllers;

import com.danieleleao.events.modules.customers.entities.Customer;
import com.danieleleao.events.modules.customers.usecases.CreateCustomerUserCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CreateCustomerController {


    // RESOURCE - /customers
    // POST - /customers
    // GET - /customers
    @Autowired

    private CreateCustomerUserCase createCustomerUserCase;

    @RequestMapping("/")
    public Customer handle(@RequestBody Customer customer) {

        return createCustomerUserCase.execute(customer);

    }
}
