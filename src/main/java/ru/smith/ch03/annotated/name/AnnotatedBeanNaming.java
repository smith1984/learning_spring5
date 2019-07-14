package ru.smith.ch03.annotated.name;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Map;

public class AnnotatedBeanNaming {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch03/app-context-annotation_non_singleton.xml");
        context.refresh();
        Map<String, Singer> beans = context.getBeansOfType(Singer.class);
        beans.forEach((k,v) -> System.out.println("id: " + k));
    }
}
