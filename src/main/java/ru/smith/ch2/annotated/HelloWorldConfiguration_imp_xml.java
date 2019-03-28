package ru.smith.ch2.annotated;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource (locations = {"classpath:spring/ch2/app-context-xml.xml"})
@Configuration
public class HelloWorldConfiguration_imp_xml {
}
