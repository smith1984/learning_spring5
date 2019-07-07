package ru.smith.ch02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.smith.ch02.annotated.HelloWorldConfiguration;
import ru.smith.ch02.decoupled.MessageRender;

public class HelloWorldSpringDI {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring/ch02/app-context.xml");
        ApplicationContext context1 = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRender messageRender = context.getBean("render", MessageRender.class);
        messageRender.render();

        MessageRender messageRender1 = context1.getBean("render", MessageRender.class);
        messageRender1.render();

    }
}
