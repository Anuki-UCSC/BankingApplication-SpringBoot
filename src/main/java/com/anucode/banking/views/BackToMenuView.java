package com.anucode.banking.views;

import com.anucode.banking.services.TransferService;

import java.util.Scanner;

public class BackToMenuView implements BankingView {
    public BackToMenuView() {

    }

    @Override
    public void showView() throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean loop = false;
        boolean returnval = false;
        do {
            System.out.println("------------------");
            System.out.println("press  1. Back to Menu   2. Exit ");
            int option = scanner.nextInt();
            System.out.println();

            switch (option){
                case 1:
                    returnval = true;
                    loop = false;
                    break;
                case 2:
                    returnval= false;
                    loop = false;
                    break;
                default:
                    loop = true;
            }
        }while (loop);

        if(returnval){
            BankServiceView bankServiceView = new BankServiceView();
            bankServiceView.provideListOfBankServicesToChoose();
        }
    }
}
