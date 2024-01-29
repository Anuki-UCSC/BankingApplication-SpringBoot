package com.anucode.banking.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class OtpServiceTest {

    @InjectMocks
    OtpService underTest;

    @Test
    void Should_ReturnTrue_WhenSentOtpSuccessfully() {
        // given
        String phoneNumber = "0712020231";

        // when
        boolean actualOutput = underTest.sentOTP(phoneNumber);

        // then
        assertTrue(actualOutput);
    }


    @Test
    void Should_ReturnTrue_When_OtpAuthorizationSuccess() {
        //given
        int otp = 221155;

        // when
        boolean actialOutput = underTest.authorizeOTP(otp);

        //then
        assertTrue(actialOutput);
    }
}
