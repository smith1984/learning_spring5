package ru.smith.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ConstructorConfusion {
    private String someValue;

    public ConstructorConfusion(String someValue) {
        this.someValue = someValue;
        System.out.println("ConstructorConfusion(String) called");
    }

    public ConstructorConfusion(int someValue) {
        System.out.println("ConstructorConfusion(int) called");
        this.someValue = "Number: " + Integer.toString(someValue);
    }

    @Override
    public String toString(){
        return  someValue;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch3/app-context-xml_ch3.xml");
        context.refresh();
        ConstructorConfusion confusion = (ConstructorConfusion) context.getBean("constructorConfusion");
        System.out.println(confusion);
        context.close();
    }
}
