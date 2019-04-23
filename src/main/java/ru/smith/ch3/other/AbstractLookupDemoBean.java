package ru.smith.ch3.other;

public abstract class AbstractLookupDemoBean implements DemoBean{

    public abstract Singer getMySinger();

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
