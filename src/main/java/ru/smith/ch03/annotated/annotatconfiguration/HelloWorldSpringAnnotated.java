package ru.smith.ch03.annotated.annotatconfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.smith.ch02.decoupled.MessageRender;

public class HelloWorldSpringAnnotated {
    public static void main(String[] args) {
        ApplicationContext context1 = new AnnotationConfigApplicationContext(HelloWorldConfiguration2.class);
        MessageRender messageRender1 = context1.getBean("renderer", MessageRender.class);
        messageRender1.render();

    }
}
