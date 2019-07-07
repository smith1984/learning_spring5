package ru.smith.ch02.helloworld;

public class HelloWorldWithCommandLine {
    public static void main(String[] args) {
        if (args.length > 0)
            System.out.println(args[0]);
        else
            System.out.println("Hell World");
    }
}
