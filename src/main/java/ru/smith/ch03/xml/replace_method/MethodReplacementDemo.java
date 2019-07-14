package ru.smith.ch03.xml.replace_method;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;
import ru.smith.ch03.xml.lookup.DemoBean;
import ru.smith.ch03.xml.lookup.Singer;

public class MethodReplacementDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch03/app-context-xml.xml");
        context.refresh();

        ReplacementTarget replacementTarget = (ReplacementTarget) context.getBean("replacementTarget");
        ReplacementTarget standardTarget = (ReplacementTarget) context.getBean("standardTarget");
        displayInfo(replacementTarget);
        displayInfo (standardTarget);

        context.close();
    }

    public static void displayInfo(ReplacementTarget target){

        System.out.println(target.formatMessage("Thanks for playing, try again!"));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");
        for (int i = 0; i < 100000; i++){
            String out = target.formatMessage("No filter in my head");
           // System.out.println(out);;
        }
        stopWatch.stop();
        System.out.println("100000 gets took - " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
