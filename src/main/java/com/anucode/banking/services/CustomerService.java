package com.anucode.banking.services;

import com.anucode.banking.dataAccess.CustomerDataAccess;
import com.anucode.banking.models.AccountData;
import com.anucode.banking.models.Customer;
import com.anucode.banking.models.CustomerData;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerDataAccess customerDataAccess;

    public CustomerService(CustomerDataAccess customerDataAccess) {
        this.customerDataAccess = customerDataAccess;
    }

    public boolean checkCustomer(Customer customer){
        boolean validated = customerDataAccess.checkCustomer(customer.getName(), customer.getNic(), customer.getAccount().getAccountNumber());
        return validated;
    }

    public void setCustomerData(Customer customer){
        CustomerData.setName(customer.getName());
        CustomerData.setNic(customer.getNic());
        AccountData.setAccountNumber(customer.getAccount().getAccountNumber());
    }
}
