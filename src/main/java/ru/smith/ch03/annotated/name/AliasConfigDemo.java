package ru.smith.ch03.annotated.name;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Arrays;
import java.util.Map;

public class AliasConfigDemo {

    @Configuration
    public static class AliasBeanConfig{
        //@Bean
        @Bean(name = {"johnMayer", "john", "johnny", "jonathan"})
        //@Award(prize = {"grammy", "platinum disk"})
        @Trophy(name = {"grammy", "platinum disk"})
        public Singer singer(){
            return new Singer();
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(AliasBeanConfig.class);
        Map<String, Singer> beans = context.getBeansOfType(Singer.class);
        beans.forEach((k,v) -> System.out.println("id: " + k + "\nAliases: " + Arrays.toString(context.getAliases(k))));
    }
}
