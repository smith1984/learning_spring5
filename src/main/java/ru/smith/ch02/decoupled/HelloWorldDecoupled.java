package ru.smith.ch02.decoupled;

public class HelloWorldDecoupled {
    public static void main(String[] args) {

        //MessageRender render = new StandardOutMessageRender();
        MessageRender render = MessageSupportFactory.getInstance().getMessageRender();

        //MessageProvider provider = new HelloWorldMessageProvider();
        MessageProvider provider = MessageSupportFactory.getInstance().getMessageProvider();
        render.setMessageProvider(provider);
        render.render();
    }
}
