package ru.smith.ch3.annotated.provider;

import org.springframework.stereotype.Component;
import ru.smith.ch2.decoupled.MessageProvider;
@Component("provider_hello")
public class HelloWorldMessageProvider implements MessageProvider{
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
