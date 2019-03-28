package ru.smith.ch2.annotated;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "ru.smith.ch3.annotated")

@Configuration
public class HelloWorldConfiguration_scan {
}
