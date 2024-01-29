package com.anucode.banking.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    private int id;
    private String name;
    private String nic;
    private Account account;
}
