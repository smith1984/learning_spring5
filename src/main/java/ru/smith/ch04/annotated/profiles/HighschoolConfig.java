package ru.smith.ch04.annotated.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.smith.ch04.xml.profiles.FoodProviderService;
import ru.smith.ch04.xml.profiles.highschool.FoodProviderServiceImpl;

@Configuration
@Profile("highschool")
public class HighschoolConfig {
    @Bean
    public FoodProviderService foodProviderService(){
        return new FoodProviderServiceImpl();
    }
}
