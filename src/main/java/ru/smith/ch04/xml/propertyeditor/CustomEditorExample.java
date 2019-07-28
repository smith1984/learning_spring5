package ru.smith.ch04.xml.propertyeditor;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomEditorExample {

    @Setter
    @Getter
    private FullName name;

    public static void main(String[] args) {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch04/app-context-02.xml");
        context.refresh();

        CustomEditorExample bean = (CustomEditorExample) context.getBean("exampleBean");
        System.out.println(bean.getName());
        context.close();
    }
}
