package ru.smith.ch04.xml.initmethod;

import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

@ToString
public class Singer {
    private static final String DEFAULT_NAME = "Eric Clapton";

    @Setter
    private String name;

    @Setter
    private int age = Integer.MIN_VALUE;

    public void init(){
        System.out.println("Initializing bean");

        if (name == null){
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("You must set the age property of any beans  of type " + Singer.class);
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch04/app-context-xml_init_method.xml");
        context.refresh();

        getBean("singerOne", context);
        getBean("singerTwo", context);
        getBean("singerThree", context);

        context.close();
    }

    public static Singer getBean(String beanName, ApplicationContext context){
        try {
            Singer bean = (Singer) context.getBean(beanName);
            System.out.println(bean);
            return bean;
        }
        catch (BeanCreationException exp){
            System.out.println("An error occured in bean configuration " + exp.getMessage());
            return null;
        }
    }
}
