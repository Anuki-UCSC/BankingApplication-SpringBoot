package com.anucode.banking.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class CustomerData {
    @Getter
    private static String name;

    @Getter
    private static String nic;

    public static void setName(String name) {
        CustomerData.name = name;
    }

    public static void setNic(String nic) {
        CustomerData.nic = nic;
    }

}
