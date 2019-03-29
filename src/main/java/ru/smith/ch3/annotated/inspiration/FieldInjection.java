package ru.smith.ch3.annotated.inspiration;

import org.springframework.context.support.GenericXmlApplicationContext;

public class FieldInjection {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch3/app-context-annotation_ch3.xml");
        context.refresh();
        Singer singer = context.getBean("singer", Singer.class);
        singer.sing();
        context.close();
    }
}
