package ru.smith.ch03.annotated.simple;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@ToString @Component("injectSimpleSpel")
public class InjectSimpleSpel {
    @Getter @Setter @Value("#{injectSimpleConfig.name}")
    private String name;

    @Getter @Setter @Value("#{injectSimpleConfig.age + 1}")
    private int age;

    @Getter @Setter @Value("#{injectSimpleConfig.height}")
    private float height;

    @Getter @Setter @Value("#{injectSimpleConfig.programmer}")
    private boolean programmer;

    @Getter @Setter @Value("#{injectSimpleConfig.ageInSeconds}")
    private Long ageInSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch03/app-context-annotation.xml");
        context.refresh();
        InjectSimpleSpel simple = (InjectSimpleSpel) context.getBean("injectSimpleSpel");
        System.out.println(simple);
        context.close();
    }
}
