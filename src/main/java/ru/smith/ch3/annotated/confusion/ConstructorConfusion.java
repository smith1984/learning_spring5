package ru.smith.ch3.annotated.confusion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("constructorConfusion")
public class ConstructorConfusion {
    private String someValue;

    public ConstructorConfusion(String someValue) {
        this.someValue = someValue;
        System.out.println("ConstructorConfusion(String) called");
    }

    @Autowired
    public ConstructorConfusion(@Value("90") int someValue) {
        System.out.println("ConstructorConfusion(int) called");
        this.someValue = "Number: " + Integer.toString(someValue);
    }

    @Override
    public String toString(){
        return  someValue;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/app-context-annotation_ch3.xml");
        context.refresh();
        ConstructorConfusion confusion = (ConstructorConfusion) context.getBean("constructorConfusion");
        System.out.println(confusion);
        context.close();
    }
}
