package ru.smith.ch04.xml.profiles;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class ProfileXmlConfigExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();

        context.load("classpath:spring/ch04/*-config.xml");
        context.refresh();

        //context.getEnvironment().setActiveProfiles("kindergarten");
        FoodProviderService service = context.getBean("foodProviderService", FoodProviderService.class);
        List<Food> lunchSet = service.providerLunchSet();

        lunchSet.forEach(f -> System.out.println(f.getName()));

        context.close();
    }
}
