package ru.smith.ch04.annotated.shutdownhookbean;

import lombok.Setter;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

public class DestructiveBeanWithInterface {

    private File file;
    @Setter
    private String filePath;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean");

        if (filePath == null) {
            throw new IllegalArgumentException("You must specify the filePath property of " + DestructiveBeanWithInterface.class);
        }
        this.file = new File(filePath);
        this.file.createNewFile();

        System.out.println("File exists: " + file.exists());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying bean");

        if (!file.delete())
            System.out.println("ERROR: failed to delete file");

        System.out.println("File exists: " + file.exists());
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch04/app-context-annotation_appcontextaware.xml");
        context.registerShutdownHook();
        context.refresh();
        DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface) context.getBean("destructiveBean", DestructiveBeanWithInterface.class);
    }
}
