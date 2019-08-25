package ru.smith.ch04.annotated.configjava;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.smith.ch02.decoupled.MessageProvider;
import ru.smith.ch02.decoupled.MessageRender;
import ru.smith.ch03.annotated.StandardOutMessageRender;
import ru.smith.ch03.xml.provider.ConfigurableMessageProvider;

public class JavaConfigSimpleDemo {

    @Configuration
    static class AppConfig {
        @Bean
        public MessageProvider messageProvider() {
            return new ConfigurableMessageProvider();
        }

        @Bean
        public MessageRender messageRenderer() {
            MessageRender renderer = new StandardOutMessageRender();
            renderer.setMessageProvider(messageProvider());

            return renderer;
        }
    }


    public static void main(String... args) {
        ApplicationContext ctx = new 
            AnnotationConfigApplicationContext(AppConfig.class);

        MessageRender renderer =
            ctx.getBean("messageRenderer", MessageRender.class);

        renderer.render();
    }
}
