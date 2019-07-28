package ru.smith.ch04.xml.factorybean;

import lombok.Setter;

import java.security.MessageDigest;

public class MessageDigester {

    @Setter
    private MessageDigest messageDigest1;
    @Setter
    private MessageDigest messageDigest2;

    public void digest(String msg){
        System.out.println("Using digest1");
        digest(msg,messageDigest1);

        System.out.println("Using digest2");
        digest(msg, messageDigest2);
    }

    private void digest (String msg, MessageDigest digest){
        System.out.println("Using algorithm: " + digest.getAlgorithm());

        digest.reset();
        byte[] bytes = msg.getBytes();
        byte[] out = digest.digest(bytes);
        System.out.println(out);
    }
}
