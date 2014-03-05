/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.scjp.tcpserver.multithread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class MulticlientTcpServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(22);

        System.out.println("Starting TCP server");

        while (true) {
            System.out.println("wait for connection");
            Socket client = server.accept();
            System.out.println("client connected");
            ClientThread clientThread = new ClientThread(client);
            clientThread.start();
        }
    }
}
