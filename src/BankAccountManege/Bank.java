package BankAccountManege;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Bank{

    Scanner sc = new Scanner(System.in);
    HashMap<String, Account> accountList = new HashMap<>();



    public String createAccount(String name) {

        String accountNum = String.valueOf((Math.random())).substring(2);
        accountList.put(accountNum, new Account(accountNum, name));

        return accountNum;
    }

    public Account getAccount(String accountNum) {
        return accountList.get(accountNum);
    }
}