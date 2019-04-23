package ru.smith.ch3.annotated.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("abstractLookupDemoBean")
public class AbstractLookupDemoBean implements DemoBean {

    @Lookup("singer")
    public Singer getMySinger(){
        return null;
    }

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
