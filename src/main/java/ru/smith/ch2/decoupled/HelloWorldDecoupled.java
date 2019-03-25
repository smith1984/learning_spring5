package ru.smith.ch2.decoupled;

public class HelloWorldDecoupled {
    public static void main(String[] args) {
        MessageRender messageRender = MessageSupportFactory.getInstance().getMessageRender();
        MessageProvider messageProvider = MessageSupportFactory.getInstance().getMessageProvider();
        messageRender.setMessageProvider(messageProvider);
        messageRender.render();
    }
}
