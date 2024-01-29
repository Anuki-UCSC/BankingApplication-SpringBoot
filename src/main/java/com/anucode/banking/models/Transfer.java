package com.anucode.banking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transfer {
    private String toAccountNumber;
    private String accountName;
    private String bankName;
    private int branchCode;
}
