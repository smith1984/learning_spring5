package ru.smith.ch3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.smith.ch2.decoupled.MessageRender;

public class DependencyPull {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/ch2/app-context.xml");
        MessageRender messageRender = context.getBean("render", MessageRender.class);
        messageRender.render();
    }
}
