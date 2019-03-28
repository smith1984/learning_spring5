package ru.smith.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.smith.ch2.decoupled.MessageProvider;
import ru.smith.ch2.decoupled.MessageRender;

public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch2/app-context-annotation.xml");
        //context.load("classpath:spring/app-context-xml.xml");
        context.refresh();
        MessageRender render = context.getBean("render", MessageRender.class);
        render.render();
        MessageProvider provider = context.getBean("provider", MessageProvider.class);
        System.out.println(provider.getMessage());
        context.close();
    }
}
