package ru.smith.ch04.annotated.destroyconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;
import ru.smith.ch04.annotated.destroyjsr250.DestructiveBeanWithJSR250;

public class DestructiveBeanConfigDemo {

    @Configuration
    static class DestructiveBeanConfig{

        @Lazy
        @Bean(initMethod = "afterPropertiesSet", destroyMethod = "destroy")
        DestructiveBeanWithJSR250 destructiveBean (){
            DestructiveBeanWithJSR250 destructiveBean = new DestructiveBeanWithJSR250();
            destructiveBean.setFilePath("test.txt");
            return destructiveBean;
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(DestructiveBeanConfig.class);
        context.getBean(DestructiveBeanWithJSR250.class);
        System.out.println("Calling destroy()");
        //context.destroy();
        context.registerShutdownHook();
        System.out.println("Called destroy()");
    }
}
