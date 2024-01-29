package com.anucode.banking.dataAccess;

import com.anucode.banking.models.Transfer;
import com.anucode.banking.models.TransferDTO;
import org.springframework.stereotype.Component;

@Component
public class TransferDataAccess {
    public Transfer getReceiverDetailsByAccountNumber() {
        Transfer transfer = new Transfer();
        transfer.setAccountName("A S Perera");
        transfer.setBankName("People's Bank");
        transfer.setBranchCode(103);

        return transfer;
    }

    public boolean transaction(TransferDTO transferDTO, String fromCustomer, String fromNic, String fromAccountNumber) {

        return true;
    }
}
