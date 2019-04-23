package ru.smith.ch3.other;

public class StandardLookupDemoBean implements DemoBean {
    private Singer mySinger;

    @Override
    public Singer getMySinger() {
        return mySinger;
    }

    public void setMySinger(Singer mySinger) {
        this.mySinger = mySinger;
    }

    @Override
    public void doSomething() {
        mySinger.sing();
    }
}
