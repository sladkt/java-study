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


    public long deposit(long money) {
        if(money <= 0){
            return -1;
        }
        currentMoney += money;

        return currentMoney;
    }

    public long withdraw(long money) {
        if(money <= 0) {
            return -2;
        }
        else if (currentMoney - money < 0) {
            return -1;
        } else {
            currentMoney -= money;
            return currentMoney;
        }
    }

    public long currentMoneyCheck() {
        return currentMoney;
    }

}