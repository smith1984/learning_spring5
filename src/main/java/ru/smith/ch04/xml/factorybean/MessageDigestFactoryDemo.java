package ru.smith.ch04.xml.factorybean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestFactoryDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context =  new GenericXmlApplicationContext();
        context.load("classpath:spring/ch04/app-context-xml_factorybean_2.xml");
        context.refresh();
        MessageDigester digester = (MessageDigester) context.getBean("digester");
        digester.digest("Hello world!");

    }
}
