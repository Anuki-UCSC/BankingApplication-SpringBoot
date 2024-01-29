package com.anucode.banking.services;


import org.springframework.stereotype.Service;

@Service
public class OtpService {
    public boolean sentOTP(String phoneNumber) {
        // send OTP to given phone number
        return true; // otp send successfully
    }

    public boolean authorizeOTP(int userGivenOtp) {
        // authorize the user given OTP
        return true; //authorized
    }
}
