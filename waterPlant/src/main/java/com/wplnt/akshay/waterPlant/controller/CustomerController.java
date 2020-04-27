package com.wplnt.akshay.waterPlant.controller;

import com.wplnt.akshay.waterPlant.entity.Customer;
import com.wplnt.akshay.waterPlant.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
public class CustomerController {
    private static final String template = "Hello, %s!";

    @Autowired
    private CustomerService csvc;

    @PostMapping("/cust")
    @ResponseBody
    public Customer get( @RequestParam List<String> values ) {
        log.info("CustomerController:: get()::starts");
        try {
            csvc.postCustomerData(values);
        } catch (Exception e) {
            log.error("CustomerService :: get() ::error ", e);

        }
        log.info("CustomerController:: get()::ends");
        return new Customer("Test", "Test", "Test", "Test", 20);
    }
}
