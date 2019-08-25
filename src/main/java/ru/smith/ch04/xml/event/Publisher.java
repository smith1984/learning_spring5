package ru.smith.ch04.xml.event;

import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Publisher implements ApplicationContextAware {

    private ApplicationContext context;

    public void publish(String msg) {
        context.publishEvent(new MessageEvent(this, msg));
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/ch04/app-context-xml_event.xml");

        Publisher publisher = (Publisher) context.getBean("publisher");
        publisher.publish("I send an SOS to the world ...");
        publisher.publish("... I hope that some gets my ...");
        publisher.publish("... Message in a bottle");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
