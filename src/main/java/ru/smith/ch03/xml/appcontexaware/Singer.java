package ru.smith.ch03.xml.appcontexaware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Singer implements ApplicationContextAware {
    ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    private Guitar guitar;

    public Singer() {
    }

    public void sing(){
        guitar = context.getBean("gopher", Guitar.class);
        guitar.sing();
    }
}
