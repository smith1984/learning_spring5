package ru.smith.ch04.xml.factorybean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestDemo {
    public static void main(String[] args) {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch04/app-context-xml_factorybean.xml");
        context.refresh();
        MessageDigester digester = context.getBean("digester", MessageDigester.class);
        digester.digest("Hello world!");
        context.close();
    }
}
