package util;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Connector implements DbConnector {

    @Override
    public String getDbMessage() {
        return "Connected to DB successfully!";
    }
}
