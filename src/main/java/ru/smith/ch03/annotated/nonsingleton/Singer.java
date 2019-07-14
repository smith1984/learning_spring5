package ru.smith.ch03.annotated.nonsingleton;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("nonSingleton")
//@Component("johnMayer")
@Scope("prototype")
public class Singer {
    private String name = "unknown";

    public Singer(@Value("JonnSmith") String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

