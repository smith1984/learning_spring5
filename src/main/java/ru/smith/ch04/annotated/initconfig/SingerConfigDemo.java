package ru.smith.ch04.annotated.initconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;
import ru.smith.ch04.xml.initmethod.Singer;

import static ru.smith.ch04.xml.initmethod.Singer.getBean;

public class SingerConfigDemo {

    @Configuration
    static class SingerConfig{

        @Lazy
        @Bean(initMethod = "init")
        Singer singerOne(){
            Singer singerOne = new Singer();
            singerOne.setName("John Mayer");
            singerOne.setAge(150);
            return singerOne;
        }

        @Lazy
        @Bean(initMethod = "init")
        Singer singerTwo(){
            Singer singerTwo = new Singer();
            singerTwo.setAge(720);
            return singerTwo;
        }

        @Lazy
        @Bean(initMethod = "init")
        Singer singerThree(){
            Singer singerThree = new Singer();
            singerThree.setName("John Butler");
            return singerThree;
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(SingerConfig.class);

        getBean("singerOne", context);
        getBean("singerTwo", context);
        getBean("singerThree", context);

    }
}
