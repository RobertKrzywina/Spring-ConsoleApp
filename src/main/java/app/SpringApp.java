package app;

import controller.Producer;
import model.BankAccount;
import model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Random;

@Configuration
@ComponentScan(basePackageClasses = Producer.class)
@EnableAspectJAutoProxy
public class SpringApp {

    private static Random random = new Random();

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringApp.class);
        Producer producer = ctx.getBean(Producer.class);

        System.out.println(producer.DataBaseConnect());

        producer.createBankAccountForUser(new User("Rob"), new BankAccount("Rob"));
        producer.createBankAccountForUser(new User("Mia"), new BankAccount("Mia"));
        producer.createBankAccountForUser(new User("Tim"), new BankAccount("Tim"));
        producer.createBankAccountForUser(new User("Joe"), new BankAccount("Joe"));

        for (int i=0; i<6; i++) {
            double randomCash = random.nextDouble();
            producer.addMoney(i, randomCash);
        }

        producer.addMoney(2, 12120.1);
        producer.addMoney(4, 1212.43);
        producer.addMoney(0, 135.33);

        producer.showInfo();
        producer.showInfoAboutAccount(2);

        ctx.close();
    }
}
