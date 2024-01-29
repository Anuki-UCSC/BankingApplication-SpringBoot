package com.anucode.banking.services;

import com.anucode.banking.dataAccess.CustomerDataAccess;
import com.anucode.banking.models.Account;
import com.anucode.banking.models.AccountType;
import com.anucode.banking.models.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @InjectMocks
    private CustomerService underTest;

    @Mock
    private CustomerDataAccess customerDataAccess;


    @Test
    void Should_ReturnTrue_When_GivenValidDetailsToCheckCustomer() {
        //given
        String name = "A A Silva";
        String nic = "985544112V";
        String accountNumber = "1002310023";
        AccountType type = AccountType.Savings;
        Customer customer = new Customer(1, name, nic);
        customer.setAccount(new Account(accountNumber, type));
        //when
        when(customerDataAccess.checkCustomer(
                customer.getName(),
                customer.getNic(),
                customer.getAccount().getAccountNumber()
        )).thenReturn(true);
        boolean actualOutput = underTest.checkCustomer(customer);

        //then
        verify(customerDataAccess, Mockito.times(1)).checkCustomer(
                customer.getName(),
                customer.getNic(),
                customer.getAccount().getAccountNumber());
        assertTrue(actualOutput);
    }

    @Test
    void Should_ReturnFalse_When_givenInvalidDetailsToCheckCustomer(){
        String name = "A A Silva";
        String nic = "900000012V";
        String accountNumber = "9999910023";
        AccountType type = AccountType.Savings;
        Customer customer = new Customer(1, name, nic);
        customer.setAccount(new Account(accountNumber, type));

        //when
        when(customerDataAccess.checkCustomer(
                customer.getName(),
                customer.getNic(),
                customer.getAccount().getAccountNumber())).thenReturn(false);
        boolean actualOutput = underTest.checkCustomer(customer);

        //then
        verify(customerDataAccess, Mockito.times(1)).checkCustomer(
                customer.getName(),
                customer.getNic(),
                customer.getAccount().getAccountNumber());
        assertFalse(actualOutput);
    }
}
