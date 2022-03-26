package me.plepis.accenture.bootcamp.day_three;

public class BankAccount {

    private double balance;

    private static final double MAX_DEPOSIT = 5000;

    public BankAccount() {
    }

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (depositLogic(amount, false)) {
            System.out.println("Successfully depositted " + amount);
        } else {
            System.out.println("Cannot deposit more than " + MAX_DEPOSIT + "! You tried depositting " + amount);
        }
    }

    public void withdraw(double amount) {
        if (withdrawLogic(amount)) {
            System.out.println("Successfully withdrew " + amount);
        } else {
            System.out.println("Cannot withdraw " + amount + " because balance is only " + balance);
        }
    }

    private boolean withdrawLogic(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    /*
     * separated withdraw logic so that it can be easily changed
     */
    private boolean depositLogic(double amount, boolean isTransaction) {
        if (amount <= MAX_DEPOSIT || isTransaction) {
            balance += amount;
            return true;
        }
        return false;

    }

    public void printBalance() {
        System.out.println("Balance for Account " + hashCode() + ": " + balance);
    }

    public void transferTo(BankAccount to, double amount) {
        if (withdrawLogic(amount)) {
            System.out.println("Successfully transfered " + amount + " to " + to.hashCode());
            to.depositLogic(amount, true);
        } else {
            System.out.println("Insufficient Funds!");
        }
    }

    void transferFrom(BankAccount from, double amount) {
        if (from.withdrawLogic(amount)) {
            System.out.println("Successfully withdrew " + amount + " from " + from.hashCode());
            depositLogic(amount, true);
        } else {
            System.out.println("Insufficient Funds!");
        }
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

}
