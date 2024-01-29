package com.anucode.banking.models;

import lombok.Getter;

public class AccountData {
    @Getter
    private static String accountNumber;

    public static void setAccountNumber(String accountNumber) {
        AccountData.accountNumber = accountNumber;
    }
}
