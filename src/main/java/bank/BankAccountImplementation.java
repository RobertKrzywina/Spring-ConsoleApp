package bank;

import model.BankAccount;
import model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Component
@Qualifier("bankProducer")
public class BankAccountImplementation implements BankAccountProducer {

    private List<BankAccount> accounts;

    public BankAccountImplementation() {
        accounts = new LinkedList<>();
    }

    @Override
    public void createAccount(BankAccount account, User user) {
        String generatedAccountNumber = generateRandomNumberAccount();
        account.setAccountNumber(generatedAccountNumber);
        account.setAccountOwner(user.getName());
        accounts.add(account);
    }

    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    private String generateRandomNumberAccount() {
        StringBuilder accountNumberSB = new StringBuilder();
        int randomNum;
        for (int i=0; i<9; i++) {
            randomNum = new Random().nextInt(10);
            // 1st number of account can't be ZERO!
            if (i == 0 && randomNum == 0) {
                randomNum +=1;
            }
            accountNumberSB.append(randomNum);
        }
        return accountNumberSB.toString();
    }

    @Override
    public void addMoney(int accountId, double amount) {
        if (isAccountExists(accountId)) {
            double actualDeposit = accounts.get(accountId - 1).getDeposit();
            accounts.get(accountId - 1).setDeposit(amount + actualDeposit);
        } else {
            accountNotExists();
        }
    }

    @Override
    public void accountInfo(int accountId) {
        if (isAccountExists(accountId)) {
            System.out.println(accounts.get(accountId - 1).toString());
        } else {
            accountNotExists();
        }
    }

    private void accountNotExists() {
        System.out.println("Account not exists!");
    }

    private boolean isAccountExists(int wantedId) {
        return wantedId <= accounts.size() && wantedId > 0;
    }
}
