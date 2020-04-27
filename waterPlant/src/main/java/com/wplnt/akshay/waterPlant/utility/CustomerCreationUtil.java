package com.wplnt.akshay.waterPlant.utility;

import com.wplnt.akshay.waterPlant.entity.Customer;
import com.wplnt.akshay.waterPlant.exception.ApplicationException;
import com.wplnt.akshay.waterPlant.exception.ErrorMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CustomerCreationUtil {

    public Customer createCustomer(List<String> values) throws ApplicationException {
        log.info("CustomerCreationUtil :: createCustomer() ::starts");
        Customer cust;
        try {
            cust = new Customer();
            cust.setName(values.get(0));
            cust.setAddress(values.get(1));
            cust.setMobileNumber(values.get(2));
            cust.setPaymentType(values.get(3));
            cust.setBootleType(Integer.parseInt(values.get(4)));
        } catch (Exception e) {
            log.error("CustomerCreationUtil :: createCustomer() ::exception", e);
            throw new ApplicationException(e, ErrorMessages.OBJECT_CREATN_FAILED);
        }
        log.info("CustomerCreationUtil :: createCustomer() ::ends");
        return cust;
    }
}
