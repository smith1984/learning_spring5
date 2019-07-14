package ru.smith.ch03.xml.autowire;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Target {

    private Foo fooOne;
    private Foo fooTwo;
    private Bar bar;

    public Target() {
    }

    public Target(Foo foo){
        System.out.println("Target (Foo) called");
    }

    public Target(Foo foo, Bar bar){
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
        context.load("classpath:spring/ch03/app-context-xml_autowire.xml");
        context.refresh();

        Target target = null;

        System.out.println("Using byName:");
        target = (Target) context.getBean("targetByName");

        System.out.println("\nUsing byType:");
        target = (Target) context.getBean("targetByType");

        System.out.println("\nUsing constructor:");
        target = (Target) context.getBean("targetConstructor");

        context.close();
    }
}
