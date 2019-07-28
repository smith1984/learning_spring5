package ru.smith.ch04.annotated.initjsr250;

import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;

@ToString
public class SingerWithJSR250 {
    private static final String DEFAULT_NAME = "Eric Clapton";

    @Setter
    private String name;

    @Setter
    private int age = Integer.MIN_VALUE;

    @PostConstruct
    public void init(){
        System.out.println("Initializing bean");

        if (name == null){
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("You must set the age property of any beans  of type " + SingerWithJSR250.class);
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch04/app-context-annotation_jsr250.xml");
        context.refresh();

        getBean("singerOne", context);
        getBean("singerTwo", context);
        getBean("singerThree", context);

        context.close();
    }

    public static SingerWithJSR250 getBean(String beanName, ApplicationContext context){
        try {
            SingerWithJSR250 bean = (SingerWithJSR250) context.getBean(beanName);
            System.out.println(bean);
            return bean;
        }
        catch (BeanCreationException exp){
            System.out.println("An error occured in bean configuration " + exp.getMessage());
            return null;
        }
    }
}
