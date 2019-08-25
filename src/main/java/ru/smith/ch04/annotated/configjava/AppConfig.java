package ru.smith.ch04.annotated.configjava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.smith.ch02.decoupled.MessageProvider;
import ru.smith.ch02.decoupled.MessageRender;
import ru.smith.ch03.annotated.StandardOutMessageRender;
import ru.smith.ch03.xml.provider.ConfigurableMessageProvider;

@Configuration
public class AppConfig {
    @Bean
    public MessageProvider messageProvider(){
        return new ConfigurableMessageProvider();
    }

    @Bean
    public MessageRender messageRender(){
        MessageRender messageRender = new StandardOutMessageRender();
        messageRender.setMessageProvider(messageProvider());
        return messageRender;
    }
}
