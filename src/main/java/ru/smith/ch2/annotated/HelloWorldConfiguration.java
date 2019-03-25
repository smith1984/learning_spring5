package ru.smith.ch2.annotated;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.smith.ch2.decoupled.HelloWorldMessageProvider;
import ru.smith.ch2.decoupled.MessageProvider;
import ru.smith.ch2.decoupled.MessageRender;
import ru.smith.ch2.decoupled.StandardOutMessageRender;

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public MessageProvider provider(){
        return new HelloWorldMessageProvider();
    }

    @Bean
    public MessageRender render(){
        MessageRender render = new StandardOutMessageRender();
        render.setMessageProvider(provider());
        return render;
    }
}
