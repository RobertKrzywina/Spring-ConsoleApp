package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectUtil {

    @Pointcut("execution(* controller.Producer.createBankAccountForUser(..))")
    public void createBankAccountForUserMethods() {}

    @Pointcut("execution(* controller.Producer.addMoney(..))")
    public void addMoneyMethods() {}
}
