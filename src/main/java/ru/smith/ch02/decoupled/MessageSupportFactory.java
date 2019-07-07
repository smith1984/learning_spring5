package ru.smith.ch02.decoupled;

import java.util.Properties;

public class MessageSupportFactory {
    private static MessageSupportFactory instance;
    private Properties properties;
    private MessageProvider messageProvider;
    private MessageRender messageRender;

    private MessageSupportFactory(){
        properties = new Properties();

        try{
            properties.load(this.getClass().getResourceAsStream("/msf.properties"));
            String renderClass = properties.getProperty("render.class");
            String providerClass = properties.getProperty("provider.class");
            messageRender = (MessageRender)Class.forName(renderClass).newInstance();
            messageProvider = (MessageProvider)Class.forName(providerClass).newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    static {instance = new MessageSupportFactory();}

    public static MessageSupportFactory getInstance(){
        return instance;
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    public MessageRender getMessageRender() {
        return messageRender;
    }
}