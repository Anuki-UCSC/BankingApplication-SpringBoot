package com.anucode.banking.models;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class Customer {
    private int id;
    private String name;
    private String nic;
    private Account account;

    public Customer(int id, String name, String nic) {
        this.id = id;
        this.name = name;
        this.nic = nic;
    }
}
