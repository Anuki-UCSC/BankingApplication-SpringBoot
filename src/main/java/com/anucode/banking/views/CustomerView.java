package com.anucode.banking.views;

import com.anucode.banking.dataAccess.CustomerDataAccess;
import com.anucode.banking.models.Account;
import com.anucode.banking.models.AccountData;
import com.anucode.banking.models.Customer;
import com.anucode.banking.services.CustomerService;
import com.anucode.banking.validations.InputValidations;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.anucode.banking.utility.ExceptionHandler.handleException;

public class CustomerView {
    private Customer user = new Customer();
    private CustomerService customerService;

    public CustomerView(CustomerService customerService) {
        this.customerService = customerService;
    }

    public boolean askCustomerDetails() throws Exception {
        boolean isValid = false;
        try {


            String name = this.askUserInputUntilValidName();

            String nic = this.askUserInputUntilValidNic();

            String accountNumber = this.askUserInputUntilValidAccount();

            this.setUser(name, nic, accountNumber);

            isValid = customerService.checkCustomer(user);

            if(isValid) {
                customerService.setCustomerData(user);
                AccountData.setAccountNumber(user.getAccount().getAccountNumber());
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            handleException("OutOfBound Error Occurred", e);
        } catch (ArithmeticException e) {
            handleException("Arithmetic Error Occurred", e);
        } catch (InputMismatchException e) {
            handleException("Invalid Input Error Occurred", e);
        } catch (Exception e) {
            handleException("Error Occurred", e);
        }

        return isValid;
    }

    private void setUser(String name, String nic, String accountNumber) {
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        user.setName(name);
        user.setNic(nic);
        user.setAccount(account);
    }

    private String askUserInputUntilValidAccount() {
        String accountNumber;
        boolean isValidAccountNumber;
        do{
            System.out.print("Enter your Account Number : ");
            Scanner scanner = new Scanner(System.in);
            accountNumber = scanner.next();
            InputValidations inputValidations = new InputValidations();
            isValidAccountNumber = inputValidations.validateAccountNumber(accountNumber);
            if(isValidAccountNumber){
                System.out.println(accountNumber);
            }else {
                System.out.println("Invalid input! Please enter valid Account Number.");
            }
        }while (!isValidAccountNumber);
        return accountNumber;
    }

    private String askUserInputUntilValidNic() {
        String nic;
        boolean isValidNic;
        do{
            System.out.print("Enter your NIC : ");
            Scanner scanner = new Scanner(System.in);
            nic = scanner.next();
            InputValidations inputValidations = new InputValidations();
            isValidNic = inputValidations.validateNIC(nic);
            if(isValidNic){
                System.out.println(nic);
            }else {
                System.out.println("Invalid input! Please enter valid NIC.");
            }
        }while (!isValidNic);
        return nic;
    }

    private String askUserInputUntilValidName(){
        String name;
        boolean isValidName;
        do{
            System.out.print("Enter name with initials : ");
            Scanner scanner = new Scanner(System.in);
            name = scanner.nextLine();
            InputValidations inputValidations = new InputValidations();
            isValidName = inputValidations.validateName(name);
            if(isValidName){
                System.out.println(name);
            }else{
                System.out.println("Invalid input! Please enter valid name.");
            }
        }while (!isValidName);
        return name;
    }
}
