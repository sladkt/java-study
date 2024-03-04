package BankAccountManege;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        String accountNum;
        Account acc = null;

        while (true) {
            System.out.println("1.계좌 생성  2.입금  3.출금  4.잔액 조회");
            System.out.println("무엇을 하시겠습니까?");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("계좌를 생성하겠습니다.");
                accountNum = bank.createAccount();
                System.out.println("고객님의 계좌번호는 " + accountNum + " 입니다.");


            } else if (choice == 2 || choice == 3 || choice == 4) {

                System.out.println("계좌번호를 입력해주세요.");
                accountNum = sc.next();

                for (Account account : bank.accountList) {
                    if (account.accountNumber.equals(accountNum)) {
                        acc = account;
                    }
                }

                assert acc != null;

                if (choice == 2) {
                    System.out.println("입금하길 원하시는 금액을 입력해주세요.");
                    long depositMoney = sc.nextLong();
                    long depositResult = acc.deposit(depositMoney);
                    if (depositResult == -1) {
                        System.out.println("입금액은 0원을 초과해야 합니다.");
                    } else {
                        System.out.println("입금 전 돈 : " + (acc.currentMoneyCheck() - depositMoney));
                        System.out.println("입금 후 돈 : " + depositResult);
                    }

                } else if (choice == 3) {
                    System.out.println("현재 금액은 " + acc.currentMoneyCheck() + "원입니다. 출금하길 원하시는 금액을 입력해주세요.");
                    long withdrawMoney = sc.nextLong();
                    long withdrawResult = acc.withdraw(withdrawMoney);
                    if (withdrawResult == -2) {
                        System.out.println("출금액은 0원을 초과하여야 합니다.");
                    } else if (withdrawResult == -1) {
                        System.out.println("현재 잔액이 부족합니다.");
                    } else {
                        System.out.println(withdrawMoney + "원을 출금하셨습니다. 남은 금액은 " + withdrawResult + " 입니다.");
                    }
                } else {
                    System.out.println("현재 잔액은 " + acc.currentMoneyCheck() + "원입니다.");
                }
            } else {
                System.out.println("다시 선택해주시기 바랍니다.");
                continue;
            }

            System.out.println("다른 작업을 하시겠습니까? >>>>  y / n");
            String yesNO = sc.next();
            if (yesNO.charAt(0) == 'y') continue;
            else break;
        }
    }
}
