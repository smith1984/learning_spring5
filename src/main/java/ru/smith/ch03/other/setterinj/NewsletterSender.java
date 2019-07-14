package ru.smith.ch03.other.setterinj;

public interface NewsletterSender {
    void setSmtpServer(String smtpServer);
    String getSmtpSever();
    void setFromAddress(String fromAddress);
    String getFromAddres();
    void send();
}
