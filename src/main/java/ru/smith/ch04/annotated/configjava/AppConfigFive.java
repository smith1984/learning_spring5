package ru.smith.ch04.annotated.configjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import ru.smith.ch02.decoupled.MessageProvider;
import ru.smith.ch02.decoupled.MessageRender;
import ru.smith.ch03.annotated.StandardOutMessageRender;

@Configuration
@ImportResource(value = "classpath:spring/ch04/app-context-03.xml")
public class AppConfigFive {
    @Autowired
    MessageProvider provider;


    @Bean
    public MessageRender messageRender(){
        MessageRender messageRender = new StandardOutMessageRender();
        messageRender.setMessageProvider(provider);
        return messageRender;
    }
}