package com.springbootacademy.batch6POS.controller;

import com.springbootacademy.batch6POS.dto.CustomerDTO;
import com.springbootacademy.batch6POS.service.CustomerService;
import com.springbootacademy.batch6POS.service.impl.CustomerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        //CustomerServiceIMPL customerServiceIMPL =new CustomerServiceIMPL();
        //customerServiceIMPL.saveCustomer(customerDTO); use dependancy injection
        customerService.saveCustomer(customerDTO);
        return"saved";
    }

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerDTO customerDTO) {

    return null;
    }


}
