package ru.smith.ch3;

public interface NewsletterSender {
    void setSmtpServer (String smtpServer);
    String getSmtpSever();
    void setFromAddress (String fromAddress);
    String getFromAddres();
    void send();
}
