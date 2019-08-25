package ru.smith.ch04.xml.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {

    @Getter
    private String msg;

    public MessageEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }
}
