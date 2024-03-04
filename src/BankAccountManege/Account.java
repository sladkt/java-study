package BankAccountManege;

public class Account {
    String accountNumber;
    String ownerName;
    long currentMoney;

    public Account(String accountNum, String name) {
        accountNumber = accountNum;
        this.ownerName = name;
        currentMoney = 0;
    }


    public long Deposit(long money) {
        currentMoney += money;

        return currentMoney;
    }

    public long Withdraw(long money) {
        if (currentMoney - money < 0) {
            return -1;
        } else {
            currentMoney -= money;
            return currentMoney;
        }
    }

    public long CurrentMoneyCheck() {
        return currentMoney;
    }

}