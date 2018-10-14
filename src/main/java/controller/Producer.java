package controller;

import bank.BankAccountProducer;
import model.BankAccount;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import util.DbConnector;

import java.util.LinkedList;
import java.util.List;

@Component
@Configuration
@ComponentScan(basePackages = {"bank", "aspects", "util"})
public class Producer {

    private List<User> users;
    private List<BankAccount> bankAccounts;

    private DbConnector connector;
    private BankAccountProducer bankProducer;

    @Autowired
    public Producer(@Qualifier("bankProducer") BankAccountProducer bankProducer,
                                               DbConnector dbConnector) {
        users = new LinkedList<>();
        bankAccounts = new LinkedList<>();
        this.bankProducer = bankProducer;
        this.connector = dbConnector;
    }

    public String DataBaseConnect() {
        return connector.getDbMessage();
    }

    public void createBankAccountForUser(User user, BankAccount account) {
        bankProducer.createAccount(account, user);
        users.add(user);
        bankAccounts.add(account);
    }

    public void addMoney(int accountId, double amount) {
        bankProducer.addMoney(accountId, amount);
    }

    public void showInfoAboutAccount(int accountId) {
        bankProducer.accountInfo(accountId);
    }

    public void showInfo() {
        System.out.println("Users: ");
        allUsers();
        System.out.println("===============");

        System.out.println("Bank Accounts: ");
        allAccounts();
        System.out.println("===============");
    }

    private void allUsers() {
        if (!users.isEmpty()) {
            for (User user : users) {
                System.out.println(user.toString());
            }
        } else {
            throw new Exceptions("found no users!");
        }
    }

    private void allAccounts() {
        if (!bankAccounts.isEmpty()) {
            for (BankAccount account : bankAccounts) {
                System.out.println(account.toString());
            }
        } else {
            throw new Exceptions("found no accounts!");
        }
    }
}
