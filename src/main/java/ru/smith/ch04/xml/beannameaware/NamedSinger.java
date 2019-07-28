package ru.smith.ch04.xml.beannameaware;

import org.springframework.beans.factory.BeanNameAware;

public class NamedSinger implements BeanNameAware {

    private String name;

    @Override
    public void setBeanName(String s) {
        this.name = s;
    }

    public void sing(){
        System.out.println("Singer " + name + " - sing()");
    }
}
