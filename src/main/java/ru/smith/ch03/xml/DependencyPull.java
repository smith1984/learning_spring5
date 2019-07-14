package ru.smith.ch03.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.smith.ch02.decoupled.MessageRender;

public class DependencyPull {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring/ch03/app-context-xml.xml");
        MessageRender messageRender = context.getBean("render", MessageRender.class);
        messageRender.render();

    }
}
