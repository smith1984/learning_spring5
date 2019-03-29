package ru.smith.ch3.annotated.inspiration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smith.ch3.annotated.inspiration.Inspiration;

@Service("singer")
public class Singer {
    @Autowired
    private Inspiration inspirationBean;
    public void sing()
    {
        System.out.println("... " + inspirationBean.getLyric());
    }
}
