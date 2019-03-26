package ru.smith.ch3.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smith.ch2.decoupled.MessageProvider;
import ru.smith.ch2.decoupled.MessageRender;
@Service("render")
public class StandardOutMessageRender implements MessageRender{

    private MessageProvider messageProvider;

    @Override
    public void render() {
        if (messageProvider == null){throw new RuntimeException("You must set the property messageProvider" +
                "of class: " + StandardOutMessageRender.class.getName());}
        System.out.println(messageProvider.getMessage());
    }

    @Override
    @Autowired
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider=provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
