
package com.springbootacademy.batch6POS.service.impl;

import com.springbootacademy.batch6POS.dto.CustomerDTO;
import com.springbootacademy.batch6POS.entity.Customer;
import com.springbootacademy.batch6POS.repo.CustomerRepo;
import com.springbootacademy.batch6POS.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getNic(),
                customerDTO.getContactNumber(),
                customerDTO.isActiveState()
        );

        if (!customerRepo.existsById(customer.getCustomerId())) {
            throw new DuplicateKeyException("customer Already Exists");

        } else{
            customerRepo.save(customer);
            return customer.getCustomerName() + "Saved";
        }

    }
}