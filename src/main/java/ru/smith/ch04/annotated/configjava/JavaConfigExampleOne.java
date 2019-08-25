package ru.smith.ch04.annotated.configjava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.smith.ch02.decoupled.MessageRender;

public class JavaConfigExampleOne  {
    public static void main(String[] args) {
        //ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigOne.class);
        //ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigOnePlus.class);
        //ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigTwo.class);
        //ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigThree.class);
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigFive.class);

        ApplicationContext context1 = new ClassPathXmlApplicationContext("classpath:spring/ch04/app-context-04.xml");
        MessageRender messageRender = context.getBean("messageRender", MessageRender.class);
        messageRender.render();

        MessageRender messageRender2 = context1.getBean("messageRender", MessageRender.class);
        messageRender2.render();;
    }
}
