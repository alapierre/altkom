/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.scjp.tcpserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class TcpServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {


        String clientSentence;
        String capitalizedSentence;
        ServerSocket server = new ServerSocket(22);

        System.out.println("Starting TCP server");

        while (true) {
            System.out.println("wait for connection");
            Socket client = server.accept();
            System.out.println("client connected");

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(client.getOutputStream());

            do {
                clientSentence = inFromClient.readLine();
                System.out.println("Received: " + clientSentence);
                capitalizedSentence = clientSentence.toUpperCase() + '\n' + '\r';
                outToClient.writeBytes(capitalizedSentence);
                System.out.println("responce sent");

            } while(!clientSentence.equals("end"));
            
            System.out.println("close client connection");
            
            inFromClient.close();
            outToClient.close();
            client.close();

        }
    }
}
