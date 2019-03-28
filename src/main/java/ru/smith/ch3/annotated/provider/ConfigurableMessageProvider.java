package ru.smith.ch3.annotated.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smith.ch2.decoupled.MessageProvider;

@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider {
    private String message;

    /*@Autowired
    public ConfigurableMessageProvider(@Value("Configurable message") String message){
        this.message = message;
    }*/

    @Autowired
    public ConfigurableMessageProvider(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
