package ru.smith.ch04.annotated.configjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import ru.smith.ch02.decoupled.MessageProvider;
import ru.smith.ch02.decoupled.MessageRender;
import ru.smith.ch03.annotated.StandardOutMessageRender;
import ru.smith.ch03.xml.provider.ConfigurableMessageProvider;

@Configuration
@PropertySource(value = "classpath:message.properties")
public class AppConfigOnePlus {

    @Autowired
    Environment env;

    @Bean
    @Lazy
    public MessageProvider messageProvider(){
        return new ConfigurableMessageProvider(env.getProperty("message"));
    }

    @Bean(name = "messageRender")
    @Scope(value = "prototype")
    @DependsOn(value = "messageProvider")
    public MessageRender messageRender(){
        MessageRender messageRender = new StandardOutMessageRender();
        messageRender.setMessageProvider(messageProvider());
        return messageRender;
    }
}
