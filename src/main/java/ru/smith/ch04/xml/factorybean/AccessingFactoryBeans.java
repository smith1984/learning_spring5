package ru.smith.ch04.xml.factorybean;

import org.apache.commons.codec.binary.Hex;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

public class AccessingFactoryBeans {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/ch04/app-context-xml_factorybean.xml");
        context.refresh();
       // context.getBean("shaDigest", MessageDigest.class);
        MessageDigestFactoryBean factoryBean = (MessageDigestFactoryBean) context.getBean("&shaDigest");

        try{
            MessageDigest shaDigest = factoryBean.getObject();
            System.out.println((Hex.encodeHexString(shaDigest.digest("Hello world!".getBytes()))).toUpperCase());

        }
        catch (Exception e){e.printStackTrace();}
    }
}
