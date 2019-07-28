package ru.smith.ch04.annotated.destroyjsr250;

import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

public class DestructiveBeanWithJSR250 {

    private File file;
    @Setter
    private String filePath;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean");

        if (filePath == null) {
                throw new IllegalArgumentException("You must specify the filePath property of " + DestructiveBeanWithJSR250.class);
        }
        this.file = new File(filePath);
        this.file.createNewFile();

        System.out.println("File exists: " + file.exists());
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destroying bean");

        if (!file.delete())
            System.out.println("ERROR: failed to delete file");

        System.out.println("File exists: " + file.exists());
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch04/app-context-annotation_destroy_jsr250.xml");

        context.refresh();
        DestructiveBeanWithJSR250 bean = (DestructiveBeanWithJSR250) context.getBean("destructiveBean");
        System.out.println("Calling destroy()");

        context.destroy();
        System.out.println("Called destroy()");
    }
}
