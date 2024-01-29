package com.anucode.banking.utility;


public class ExceptionHandler {
    public static void handleException(String message, Exception e) throws Exception {
        System.out.println(message + " : " + e);
//        BackToMenuView backToMenuView = new BackToMenuView();
//        backToMenuView.showView();
    }
}
