package com.anucode.banking.dataAccess;

import org.springframework.stereotype.Component;

@Component
public class CustomerDataAccess {

    public boolean checkCustomer(String name, String nic, String accountNumber){
        return true; // assuming the response = true
    }

    public String retrievePhoneNumber(String user, String nic) {
        return "0719090221";
    }
}
