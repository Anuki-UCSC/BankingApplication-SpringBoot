package com.anucode.banking.services;

import com.anucode.banking.dataAccess.AccountDataAccess;
import com.anucode.banking.dataAccess.CustomerDataAccess;
import com.anucode.banking.dataAccess.TransferDataAccess;
import com.anucode.banking.models.AccountData;
import com.anucode.banking.models.CustomerData;
import com.anucode.banking.models.Transfer;
import com.anucode.banking.models.TransferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    private TransferDataAccess transferDataAccess;
    private AccountDataAccess accountDataAccess;
    private CustomerDataAccess customerDataAccess;
    private OtpService otpService;

    public TransferService() {
        this.transferDataAccess = new TransferDataAccess();
        this.accountDataAccess = new AccountDataAccess();
        this.customerDataAccess = new CustomerDataAccess();
        this.otpService = new OtpService();
    }

    public Transfer getReceiverDetails(String accountNumber) {
        Transfer receiverDetails = transferDataAccess.getReceiverDetailsByAccountNumber();
        return receiverDetails;
    }

    public boolean accountBalanceValidation(TransferDTO transferDTO) {
        boolean isValid = accountDataAccess.accountBalanceValidation(
                AccountData.getAccountNumber(),
                CustomerData.getNic(),
                transferDTO.getAmount()
        );
        return isValid;
    }

    public void sendOTP(String user, String nic){
        String phoneNumber = customerDataAccess.retrievePhoneNumber(user, nic);
        boolean success = otpService.sentOTP(phoneNumber);
    }

    public boolean authorizeAndProceedTransaction(int userGivenOtp, TransferDTO transferDto){
        boolean authorize = otpService.authorizeOTP(userGivenOtp);
        if(!authorize){
            return false;
        }
        String fromCustomer = CustomerData.getName();
        String fromNic = CustomerData.getNic();
        String fromAccountNumber = AccountData.getAccountNumber();
        boolean success = transferDataAccess.transaction(transferDto, fromCustomer, fromNic, fromAccountNumber);
        if (!success) {
            return false;
        }
        return true;
    }
}
