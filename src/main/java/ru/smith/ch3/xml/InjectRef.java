package ru.smith.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.smith.ch3.other.Oracle;

public class InjectRef {
    private Oracle oracle;

    public void setOracle(Oracle oracle) {
        this.oracle = oracle;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch3/app-context-xml_ch3.xml");
        context.refresh();
        InjectRef injectRef = (InjectRef) context.getBean("injectRef");
        System.out.println(injectRef);
        context.close();
    }

    @Override
    public String toString() {
        return oracle.defineMeaningOfLife();
    }
}
