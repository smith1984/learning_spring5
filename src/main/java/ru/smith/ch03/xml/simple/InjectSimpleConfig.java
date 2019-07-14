package ru.smith.ch03.xml.simple;

import lombok.Getter;
import lombok.Setter;

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
