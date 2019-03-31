package ru.smith.ch3.annotated.simple;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component("injectSimpleConfig")
public class InjectSimpleConfig {
    @Getter @Setter
    private String name = "Maksim Petrov";

    @Getter @Setter
    private int age = 35;

    @Getter @Setter
    private float height = 1.74f;

    @Getter @Setter
    private boolean programmer = true;

    @Getter @Setter
    private Long ageInSeconds = 1_241_401_112L;
}
