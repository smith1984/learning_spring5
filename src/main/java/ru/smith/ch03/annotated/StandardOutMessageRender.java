package ru.smith.ch03.annotated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smith.ch02.decoupled.MessageProvider;
import ru.smith.ch02.decoupled.MessageRender;
@Service("renderer")
public class StandardOutMessageRender implements MessageRender {
    private MessageProvider messageProvider;

    public StandardOutMessageRender() {
        System.out.println("--> StandardOutMessageRender: constructor called");
    }

    @Override
    public void render() {
        if (messageProvider == null)
            throw new RuntimeException("You must set the property messageProvider of class: "
            + StandardOutMessageRender.class.getName());
        System.out.println(messageProvider.getMessage());
    }

    @Override
    //@Autowired
    public void setMessageProvider(MessageProvider provider) {
        System.out.println("--> StandardOutMessageRender: setting the provider");
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
