package ru.smith.ch03.annotated.name;

import org.springframework.stereotype.Component;

@Component
//@Component("johnMayer")
public class Singer {
    private String lyric = "I played a quick game of chess with the salt and pepper shaker";
    public void sing (){
        System.out.println(lyric);
    }
}
