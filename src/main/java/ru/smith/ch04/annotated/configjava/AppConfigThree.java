package ru.smith.ch04.annotated.configjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.smith.ch02.decoupled.MessageProvider;
import ru.smith.ch02.decoupled.MessageRender;
import ru.smith.ch03.annotated.StandardOutMessageRender;

@Configuration
@Import(AppConfigFour.class)
public class AppConfigThree {
    @Autowired
    MessageProvider provider2;


    @Bean
    public MessageRender messageRender(){
        MessageRender messageRender = new StandardOutMessageRender();
        messageRender.setMessageProvider(provider2);
        return messageRender;
    }
}