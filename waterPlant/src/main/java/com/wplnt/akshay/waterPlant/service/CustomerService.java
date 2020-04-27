package com.wplnt.akshay.waterPlant.service;


import com.wplnt.akshay.waterPlant.entity.Customer;
import com.wplnt.akshay.waterPlant.exception.ApplicationException;
import com.wplnt.akshay.waterPlant.utility.CustomerCreationUtil;
import com.wplnt.akshay.waterPlant.utility.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CustomerService implements BaseService {

    @Autowired
    ExcelUtil excelUtil;

    @Value("${sheetPath}")
    private String excelFilePath;

    @Autowired
    CustomerCreationUtil custUtil;

    public Boolean postCustomerData(List<String> values) throws ApplicationException {
        log.info("CustomerService :: postData() ::starts");
        Boolean flag = Boolean.FALSE;
        List<Customer> customerList = new ArrayList<>();
        try {
            //First get the Customer object from the list
            Customer customer = custUtil.createCustomer(values);
            customerList.add(customer);
            //Create Excel sheet from the object
         /*   List<Customer> customerList = Arrays.asList(new Customer("Test_1", "address_1", "", "Monthly", 20),
                    new Customer("Test_2", "address_2", "", "Daily", 15));*/
            excelUtil.write(customerList, excelFilePath);
            flag = Boolean.TRUE;
        } catch (Exception e) {
            log.error("CustomerService :: postData() ::error ", e);
            throw e;
        }
        log.info("CustomerService :: postData() ::ends");
        return flag;
    }
}
