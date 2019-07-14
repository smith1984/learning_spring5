package ru.smith.ch03.xml.autowire.complicated;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CTarget {

    private Foo fooOne;
    private Foo fooTwo;
    private Bar bar;

    public CTarget() {
    }

    public CTarget(Foo foo){
        System.out.println("Target (Foo) called");
    }

    public CTarget(Foo foo, Bar bar){
        System.out.println("Target (Foo, Bar) called");
    }

    public void setFooOne(Foo foo) {
        this.fooOne = foo;
        System.out.println("Property fooOne set");
    }

    public void setFooTwo(Foo fooTwo) {
        this.fooTwo = fooTwo;
        System.out.println("Property fooTwo set");
    }

    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("Property bar set");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch03/app-context-xml_autowire_complicated.xml");
        context.refresh();

        CTarget target = null;

        System.out.println("\nUsing byType:");
        target = (CTarget) context.getBean("targetByType");

        context.close();
    }
}
