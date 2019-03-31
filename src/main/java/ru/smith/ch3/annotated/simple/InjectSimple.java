package ru.smith.ch3.annotated.simple;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@ToString
@Service("injectSimple")
public class InjectSimple {
    @Getter @Setter @Value("Maksim Petrov")
    private String name;

    @Getter @Setter @Value("35")
    private int age;

    @Getter @Setter @Value("1.74")
    private float height;

    @Getter @Setter @Value("true")
    private boolean programmer;

    @Getter @Setter @Value("1241401112")
    private Long ageInSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch3/app-context-annotation_ch3.xml");
        context.refresh();
        InjectSimple simple = (ru.smith.ch3.annotated.simple.InjectSimple) context.getBean("injectSimple");
        System.out.println(simple);
        context.close();
    }
}
