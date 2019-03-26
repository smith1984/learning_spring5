package ru.smith.ch3.annotation;

import org.springframework.stereotype.Component;
import ru.smith.ch2.decoupled.MessageProvider;
@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider{
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
