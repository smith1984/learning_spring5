package ru.smith.ch3.annotated.lookup;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.util.StopWatch;

public class LookupConfigDemo {
    @Configuration
    @ComponentScan(basePackages = {"ru.smith.ch3.annotated.lookup"})
    public static class LookupConfig{}

    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(LookupConfig.class);
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
