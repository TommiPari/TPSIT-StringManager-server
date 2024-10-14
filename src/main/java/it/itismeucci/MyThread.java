package it.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyThread extends Thread {
    private Socket s;
    
    public MyThread(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            int scelta;
            do {
                scelta = Integer.parseInt(in.readLine());
                String stringaRicevuta = in.readLine();
                System.out.println("Stringa ricevuta: " + stringaRicevuta);
                switch (scelta) {
                    case 1:
                        out.writeBytes(stringaRicevuta.toUpperCase() + "\n");
                        break;
                    case 2:
                        out.writeBytes(stringaRicevuta.toLowerCase() + "\n");
                        break;
                    case 3:
                        StringBuilder sb = new StringBuilder(stringaRicevuta);
                        out.writeBytes(sb.reverse() + "\n");
                        break;    
                    case 4:
                        out.writeBytes(stringaRicevuta.length() + "\n");
                        break;
                    case 0:
                        System.out.println("Comunicazione terminata!!");
                        break;
                    default:
                        out.writeBytes("Scelta non valida!");
                        break;
                }
            } while (scelta != 0);
        } catch (IOException e) {
            System.out.println("IOException!!");
        }
    }
}