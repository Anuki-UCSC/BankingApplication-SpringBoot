package com.anucode.banking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferDTO extends Transfer{
    private int amount;
    private String purpose;

    public TransferDTO(String toAccountNumber, String accountName, String bankName, int branchCode, int amount, String purpose) {
        super(toAccountNumber,accountName,bankName,branchCode);
        this.amount = amount;
        this.purpose = purpose;
    }
}
