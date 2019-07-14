package ru.smith.ch03.annotated.lookup;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch03/app-context-annotation_lookup.xml");
        context.refresh();

        DemoBean abstractBean = context.getBean("abstractLookupDemoBean", DemoBean.class);
        DemoBean standardBean = context.getBean("standardLookupDemoBean", DemoBean.class);

        displayInfo("abstractLookupDemoBean", abstractBean);
        displayInfo ("standardLookupDemoBen", standardBean);

        context.close();
    }

    public static void displayInfo(String beanName, DemoBean bean){
        Singer singer = bean.getMySinger();
        Singer singer1 = bean.getMySinger();

        System.out.println("" + beanName + ": " + "Singer Instances the Same?" + (singer==singer1));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for (int i = 0; i < 100000; i++){
            Singer singer2 = bean.getMySinger();
            singer2.sing();
        }
        stopWatch.stop();
        System.out.println("100000 gets took - " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
