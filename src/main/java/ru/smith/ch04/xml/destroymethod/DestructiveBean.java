package ru.smith.ch04.xml.destroymethod;

import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

public class DestructiveBean implements InitializingBean {

    private File file;
    @Setter
    private String filePath;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean");

        if (filePath == null) {
                throw new IllegalArgumentException("You must specify the filePath property of " + DestructiveBean.class);
        }
        this.file = new File(filePath);
        this.file.createNewFile();

        System.out.println("File exists: " + file.exists());
    }

    public void destroy(){
        System.out.println("Destroying bean");

        if (!file.delete())
            System.out.println("ERROR: failed to delete file");

        System.out.println("File exists: " + file.exists());
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch04/app-context-xml_destructive.xml");

        context.refresh();
        DestructiveBean bean = (DestructiveBean) context.getBean("destructiveBean");
        System.out.println("Calling destroy()");

        context.destroy();
        System.out.println("Called destroy()");
    }
}
