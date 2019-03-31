package ru.smith.ch3.xml;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {
    @Getter @Setter
    private Map<String, Object> map;

    @Getter @Setter
    private Properties properties;

    @Getter @Setter
    private Set set;

    @Getter @Setter
    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch3/app-context-xml_ch3.xml");
        context.refresh();

        CollectionInjection instance = (CollectionInjection) context.getBean("injectCollection");
        instance.displayInfo();
        context.close();
    }

    public void displayInfo(){
        System.out.println("Map contents:\n");
        map.forEach((key, value) -> System.out.println("Key: " + key + " - Value: " + value));

        System.out.println("\nProperties contents:\n");
        properties.forEach((key, value) -> System.out.println("Key: " + key + " - Value: " + value));

        System.out.println("\nSet contents:\n");
        set.forEach(obj -> System.out.println("Values: " + obj));

        System.out.println("\nList contents:\n");
        list.forEach(obj -> System.out.println("Values: " + obj));
    }
}
