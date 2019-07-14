package ru.smith.ch03.annotated.annotatconfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@ImportResource(locations = "spring/ch03/app-context-xml.xml")

@ComponentScan(basePackages = "ru.smith.ch03.annotated")
@Configuration
public class HelloWorldConfiguration2 {

}
