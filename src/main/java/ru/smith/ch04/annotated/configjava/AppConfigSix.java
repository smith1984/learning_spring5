package ru.smith.ch04.annotated.configjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import ru.smith.ch02.decoupled.MessageProvider;
import ru.smith.ch02.decoupled.MessageRender;
import ru.smith.ch03.annotated.StandardOutMessageRender;
import ru.smith.ch03.xml.provider.ConfigurableMessageProvider;

@Configuration
//@ImportResource(value = "classpath:spring/ch04/app-context-03.xml")
public class AppConfigSix {
    //@Autowired
    //MessageProvider provider;
@Bean
    MessageProvider provider(){
    return new ConfigurableMessageProvider("Love on the weekend");
}
}