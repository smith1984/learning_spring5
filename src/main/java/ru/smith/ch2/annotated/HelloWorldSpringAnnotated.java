package ru.smith.ch2.annotated;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.smith.ch2.decoupled.MessageRender;

public class HelloWorldSpringAnnotated {
    public static void main(String[] args) {
        //ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        //ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration_scan.class);
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration_imp_xml.class);
        MessageRender render = context.getBean("render", MessageRender.class);
        render.render();
    }
}
