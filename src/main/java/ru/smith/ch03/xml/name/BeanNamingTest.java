package ru.smith.ch03.xml.name;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;
import java.util.Map;

public class BeanNamingTest {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch03/app-context-xml_name.xml");
        context.refresh();
        Map<String, String> beans = context.getBeansOfType(String.class);
        beans.forEach((key, value) -> System.out.println(key));

        String s1 = (String) context.getBean("john");
        String s2 = (String) context.getBean("jon");
        String s3 = (String) context.getBean("jonathan");
        String s4 = (String) context.getBean("johnny");
        String s5 = (String) context.getBean("jim");
        String s6 = (String) context.getBean("ion");

        System.out.println((s1 == s2));
        System.out.println((s3 == s2));
        System.out.println((s3 == s4));
        System.out.println((s4 == s5));
        System.out.println((s5 == s6));

        System.out.println(Arrays.toString(context.getAliases("john")));
        System.out.println(Arrays.toString(context.getAliases("johnny")));
        System.out.println(Arrays.toString(context.getAliases("jon johnny,jonathan;jim")));
    }

}
