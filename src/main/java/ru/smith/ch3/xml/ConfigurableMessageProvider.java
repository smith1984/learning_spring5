package ru.smith.ch3.xml;

import ru.smith.ch2.decoupled.MessageProvider;

public class ConfigurableMessageProvider implements MessageProvider {
    private String message;

    public ConfigurableMessageProvider(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
