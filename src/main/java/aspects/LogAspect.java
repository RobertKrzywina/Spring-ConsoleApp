package aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Before("execution(* controller.Producer.DataBaseConnect(..))")
    public void applicationStarted() {
        System.out.println("@Before -> Application started!");
    }

    @Before("AspectUtil.createBankAccountForUserMethods()")
    public void beforeNewUser() {
        System.out.println("@Before -> Log for a new User");
    }

    @After("AspectUtil.createBankAccountForUserMethods()")
    public void afterNewUser() {
        System.out.println("@After -> Log for a new User");
    }

    @Before("AspectUtil.addMoneyMethods()")
    public void beforeAddMoney() {
        System.out.println("@Before -> Log for an add money");
    }

    @After("AspectUtil.addMoneyMethods()")
    public void afterAddMoney() {
        System.out.println("@After -> Log for an add money");
    }
}
