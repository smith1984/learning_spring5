package ru.smith.ch04.xml.factorybean;

import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.security.MessageDigest;

public class MessageDigestFactory {

    @Setter
    private String algorithmName = "MD5";

    public MessageDigest createInstance() throws Exception{
        return MessageDigest.getInstance(algorithmName);
    }
}
