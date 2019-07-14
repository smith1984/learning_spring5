package ru.smith.ch03.annotated.inspiration;

import org.springframework.context.support.GenericXmlApplicationContext;

public class FieldInjection {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch03/app-context-annotation.xml");
        context.refresh();
        Singer singer = context.getBean("singer", Singer.class);
        singer.sing();
        context.close();
    }
}
