package com.greenfoxacademy.bankofsimba.service;

import com.greenfoxacademy.bankofsimba.models.BankAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class AccountsList {

    public static List<BankAccount> accountList = new ArrayList<>(Arrays.asList(
            new BankAccount("Simba", 2000.00, "lion", true, true),
            new BankAccount("Scar", 50000.00, "lion", false, false),
            new BankAccount("Mufasa", 200.00, "lion", true, true),
            new BankAccount("Timon", 3000.00, "rat", false, true),
            new BankAccount("Rafiki", -100.00, "monkey", false, true),
            new BankAccount("Pumba", 250.00, "boar", false, true)
    ));

    public static List<BankAccount> getAccountList() {
        return accountList;
    }

    public static void setAccountList(String name) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getName().equals(name) && accountList.get(i).getKing() == true) {
                accountList.get(i).setBalance(accountList.get(i).getBalance() + 100.00);
            } else if (accountList.get(i).getName().equals(name) && accountList.get(i).getKing() == false) {
                accountList.get(i).setBalance(accountList.get(i).getBalance() + 100.00);
            }
        }
    }
}



