package model;

public class BankAccount {
    private final int id;
    private String accountOwner;
    private String accountNumber;
    private double deposit;

    private static int idTemp = 0;

    public BankAccount(String accountOwner) {
        id = ++idTemp;
        this.accountOwner = accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return "id = " + id + ", owner = " + accountOwner + ", account number = " + accountNumber +
               ", current deposit = " + deposit;
    }
}
