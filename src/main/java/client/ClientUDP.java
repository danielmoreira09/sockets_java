/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class ClientUDP {
     public static void main(String[] args) throws UnknownHostException, IOException{
        //calculando tempo
        long tempoInicial = System.currentTimeMillis();
         
        String msg = new String();
        msg = "solicitar ip server";
        byte[] data = msg.getBytes();
        int porta = 12345;
        String ip = "255.255.255.255";
         
        try {
            DatagramSocket client = new DatagramSocket();
            InetAddress ina = InetAddress.getByName(ip);
            DatagramPacket enviando = new DatagramPacket(data, data.length, ina, porta);
            client.send(enviando);
             
            byte[] receive = new byte[1024];
            DatagramPacket recebendo = new DatagramPacket(receive, receive.length, ina, porta);
            client.receive(recebendo);
            
            String ipServidor = recebendo.getAddress().toString();
            System.out.println("ipServidor: "+ipServidor);
            client.close();
        
            long tempoFinal = System.currentTimeMillis();
            System.out.printf("%.9f ms", (double)(tempoFinal - tempoInicial) / 1000L);
         
        } catch (SocketException ex) {
            Logger.getLogger(ClientUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
}
