package ru.smith.ch03.annotated.provider;

import org.springframework.stereotype.Component;
import ru.smith.ch02.decoupled.MessageProvider;

@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello World";
    }
}
