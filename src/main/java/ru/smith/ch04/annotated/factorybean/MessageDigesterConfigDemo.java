package ru.smith.ch04.annotated.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import ru.smith.ch04.xml.factorybean.MessageDigestFactoryBean;
import ru.smith.ch04.xml.factorybean.MessageDigester;

public class MessageDigesterConfigDemo {

    @Configuration
    static class MessageDigesterConfig{
        @Bean
        MessageDigestFactoryBean shaDigest(){
            MessageDigestFactoryBean factoryOne = new MessageDigestFactoryBean();
            factoryOne.setAlgorithmName("SHA1");
            return factoryOne;
        }

        @Bean
        MessageDigestFactoryBean defaultDigest(){
            return new MessageDigestFactoryBean();
        }

        @Bean
        MessageDigester digester() throws Exception {
            MessageDigester digester = new MessageDigester();
            digester.setMessageDigest1(shaDigest().getObject());
            digester.setMessageDigest2(defaultDigest().getObject());

            return digester;
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(MessageDigesterConfig.class);
        MessageDigester digester = (MessageDigester) context.getBean("digester");
        digester.digest("Hello world!");
    }
}
