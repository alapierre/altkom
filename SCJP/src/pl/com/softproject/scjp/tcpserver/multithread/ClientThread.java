/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.scjp.tcpserver.multithread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class ClientThread extends Thread {

    private Socket client;
    private BufferedReader inFromClient;
    private DataOutputStream outToClient;

    public ClientThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {

        try {

            inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outToClient = new DataOutputStream(client.getOutputStream());

            String clientSentence = null;

            do {
                clientSentence = inFromClient.readLine();
                System.out.println("Received: " + clientSentence);
                String capitalizedSentence = clientSentence.toUpperCase() + '\n' + '\r';
                outToClient.writeBytes(capitalizedSentence);
                System.out.println("responce sent");

            } while (!clientSentence.equals("end"));

            System.out.println("close client connection");

        } catch (IOException ex) {
            System.out.println("błąd operacji I/O");
            ex.printStackTrace();

        } finally {
            try {
                inFromClient.close();
                outToClient.close();
                client.close();
            } catch (IOException ex) {
                System.out.println("błąd zamykania połączania");
                ex.printStackTrace();
            }
        }
        System.out.println("Thread end");
    }
}
