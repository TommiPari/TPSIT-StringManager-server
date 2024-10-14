package it.itismeucci;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Il server è partito!");
        ServerSocket ss = new ServerSocket(3000);

        while (true) {
            Socket s = ss.accept();
            System.out.println("Qualcuno si è collegato!!");
            MyThread t = new MyThread(s);
            t.start();
        }

    }
}