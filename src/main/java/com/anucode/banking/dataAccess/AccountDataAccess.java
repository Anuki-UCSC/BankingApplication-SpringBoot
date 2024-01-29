package com.anucode.banking.dataAccess;

import com.anucode.banking.models.Transfer;
import com.anucode.banking.models.TransferDTO;
import org.springframework.stereotype.Component;

@Component
public class AccountDataAccess {
    public boolean accountBalanceValidation(String fromAccountNumber, String nic, int amount) {

        return true;
    }
}
