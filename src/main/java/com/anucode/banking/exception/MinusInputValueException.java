package com.anucode.banking.exception;

public class MinusInputValueException extends Exception {
    public MinusInputValueException() {
    }
    public MinusInputValueException(String message) {
        super(message);
    }

    public MinusInputValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public MinusInputValueException(Throwable cause) {
        super(cause);
    }
}
