package ru.smith.ch04.annotated.profiles;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import ru.smith.ch04.xml.profiles.Food;
import ru.smith.ch04.xml.profiles.FoodProviderService;

import java.util.List;

public class ProfileJavaConfigExample {
    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(KindergartenConfig.class, HighschoolConfig.class);

        FoodProviderService service = context.getBean("foodProviderService", FoodProviderService.class);
        List<Food> lunchSet = service.providerLunchSet();

        lunchSet.forEach(f -> System.out.println(f.getName()));

        context.close();
    }
}
