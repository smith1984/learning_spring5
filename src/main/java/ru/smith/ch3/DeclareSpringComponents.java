package ru.smith.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.smith.ch2.decoupled.MessageRender;

public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/app-context-annotation.xml");
        //context.load("classpath:spring/app-context-xml.xml");
        context.refresh();
        MessageRender render = context.getBean("render", MessageRender.class);
        render.render();
        context.close();
    }
}
