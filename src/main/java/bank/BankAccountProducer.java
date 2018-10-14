package bank;

import model.BankAccount;
import model.User;

public interface BankAccountProducer {
    void createAccount(BankAccount account, User user);
    void addMoney(int accountId, double amount);
    void accountInfo(int accountId);
}
