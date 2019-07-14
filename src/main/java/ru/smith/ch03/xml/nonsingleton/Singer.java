package ru.smith.ch03.xml.nonsingleton;

import org.springframework.beans.factory.annotation.Value;

public class Singer {
    private String name = "unknown";

    public Singer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
