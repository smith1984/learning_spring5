package ru.smith.ch03.annotated.nonsingleton;

import org.springframework.context.support.GenericXmlApplicationContext;

public class NonSingletonDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch03/app-context-annotation_non_singleton.xml");
        context.refresh();
        Singer s1 = context.getBean("nonSingleton", Singer.class);
        Singer s2 = context.getBean("nonSingleton", Singer.class);

        System.out.println("Identity equal?: " + (s1 == s2));
        System.out.println("Value equal?: " + (s1.equals(s2)));
        System.out.println(s1);
        System.out.println(s2);
    }
}
