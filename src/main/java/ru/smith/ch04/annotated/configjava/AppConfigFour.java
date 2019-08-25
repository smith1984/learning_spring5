package ru.smith.ch04.annotated.configjava;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "ru.smith.ch03.annotated.provider")
public class AppConfigFour {
}
