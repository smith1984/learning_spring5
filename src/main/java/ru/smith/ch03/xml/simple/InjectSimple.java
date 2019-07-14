package ru.smith.ch03.xml.simple;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.support.GenericXmlApplicationContext;

@ToString
public class InjectSimple {
    @Getter @Setter
    private String name;

    @Getter @Setter
    private int age;

    @Getter @Setter
    private float height;

    @Getter @Setter
    private boolean programmer;

    @Getter @Setter
    private Long ageInSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch03/app-context-xml.xml");
        context.refresh();
        InjectSimple simple = (InjectSimple) context.getBean("injectSimple");
        System.out.println(simple);
        context.close();
    }
}
