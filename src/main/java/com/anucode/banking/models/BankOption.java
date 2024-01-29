package com.anucode.banking.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankOption {
    private int number;
    private String displayName;
    private String code;
}
