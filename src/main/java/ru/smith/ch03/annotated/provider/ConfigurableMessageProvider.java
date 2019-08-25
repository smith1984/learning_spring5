package ru.smith.ch03.annotated.provider;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.smith.ch02.decoupled.MessageProvider;
@Service("provider2")
public class ConfigurableMessageProvider implements MessageProvider {
    private String message;
    @Autowired
    public ConfigurableMessageProvider(@Value("Configurable value") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
