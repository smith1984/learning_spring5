package ru.smith.ch2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.smith.ch2.annotated.HelloWorldConfiguration;
import ru.smith.ch2.decoupled.MessageRender;

public class HelloWorldSpringDI {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/ch2/app-context.xml");
        ApplicationContext context1 = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRender messageRender = context.getBean("render", MessageRender.class);
        messageRender.render();
        messageRender = context1.getBean("render", MessageRender.class);
        messageRender.render();
    }
}
