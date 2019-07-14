package ru.smith.ch03.xml;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.smith.ch02.decoupled.MessageProvider;
import ru.smith.ch02.decoupled.MessageRender;

public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        //context.load("classpath:spring/ch03/app-context-annotation.xml");
        context.load("classpath:spring/ch03/app-context-xml.xml");
        context.refresh();
        MessageRender renderer = context.getBean("renderer", MessageRender.class);
        renderer.render();
        MessageProvider provider = context.getBean("provider", MessageProvider.class);
        context.close();
    }
}
