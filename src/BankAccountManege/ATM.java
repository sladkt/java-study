package BankAccountManege;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        String accountNum;

        while (true) {
            System.out.println("1.계좌 생성  2.입금  3.출금  4.잔액 조회");
            System.out.println("무엇을 하시겠습니까?");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("계좌를 생성하겠습니다.");
                accountNum = bank.CreateAccount();
                System.out.println("고객님의 계좌번호는 " + accountNum + " 입니다.");


            } else if (choice == 2) {
                System.out.println("입금을 선택하셨습니다. 계좌번호를 입력해주세요.");
                accountNum = sc.next();
                for (Account account : bank.accountList) {
                    if (account.accountNumber.equals(accountNum)) {
                        System.out.println("입금하길 원하시는 금액을 입력해주세요.");
                        long depositMoney = sc.nextLong();
                        System.out.println("입금 전 돈 : " + account.CurrentMoneyCheck());
                        System.out.println("입금 후 돈 : " + account.Deposit(depositMoney));
                        break;
                    }
                }

            } else if (choice == 3) {
                System.out.println("출금을 선택하셨습니다. 계좌번호를 입력해주세요.");
                accountNum = sc.next();

                for (Account account : bank.accountList) {
                    if (account.accountNumber.equals(accountNum)) {
                        System.out.println("현재 금액은 " + account.CurrentMoneyCheck() + "원입니다. 출금하길 원하시는 금액을 입력해주세요.");
                        long withdrawMoney = sc.nextLong();
                        long result = account.Withdraw(withdrawMoney);
                        if (result != -1) {
                            System.out.println(withdrawMoney + "원을 출금하셨습니다. 남은 금액은 " + result + " 입니다.");
                        } else {
                            System.out.println("현재 잔액이 부족합니다.");
                        }

                        break;
                    }
                }


            } else if (choice == 4) {
                System.out.println("잔액 조회를 선택하셨습니다. 계좌번호를 입력해주세요");
                accountNum = sc.next();
                for (Account account : bank.accountList) {
                    if (account.accountNumber.equals(accountNum)) {
                        System.out.println("현재 잔액은 " + account.CurrentMoneyCheck() + "원입니다.");
                        break;
                    }
                }

            } else {
                System.out.println("다시 선택해주시기 바랍니다.");
                continue;
            }

            System.out.println("다른 작업을 하시겠습니까? >>>>   y / n");
            String yesNO = sc.next();
            if (yesNO.charAt(0) == 'y') continue;
            else break;
        }
    }
}
