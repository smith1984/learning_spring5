package ru.smith.ch04.xml.beannameaware;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.lang.reflect.GenericArrayType;

public class NamedSingerDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch04/app-context-xml_beannameaware.xml");
        context.refresh();

        NamedSinger singer = (NamedSinger) context.getBean("johnMayer");

        singer.sing();
    }
}
