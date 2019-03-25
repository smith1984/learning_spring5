package ru.smith.ch2.decoupled;

public class StandardOutMessageRender implements MessageRender{

    private MessageProvider messageProvider;

    @Override
    public void render() {
        if (messageProvider == null){throw new RuntimeException("You must set the property messageProvider" +
                "of class: " + StandardOutMessageRender.class.getName());}
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider=provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
