package BankAccountManege;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank{

    Scanner sc = new Scanner(System.in);
    ArrayList<Account> accountList = new ArrayList<>();

    static String accountNum;

    public String createAccount() {

        accountNum = String.valueOf((Math.random())).substring(2);
        System.out.println("고객님의 성함을 입력해주세요.");
        String name = sc.next();
        accountList.add(new Account(accountNum, name));

        return accountNum;
    }
}