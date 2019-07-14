package ru.smith.ch03.xml.replace_method;

public class ReplacementTarget {
    public String formatMessage (String msg){
        return "<h1>" + msg + "<h1>";
    }

    public String formatMessage (Object msg){
        return "<h1>" + msg + "<h1>";
    }
}
