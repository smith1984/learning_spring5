package ru.smith.ch04.xml.event;

import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {
    @Override
    public void onApplicationEvent(MessageEvent messageEvent) {

        MessageEvent msgEvent = (MessageEvent) messageEvent;
        System.out.println("Received: " + msgEvent.getMsg());
    }
}
