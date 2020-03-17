/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class ServerUDP {
    public static void main(String[] args) throws IOException{
         
        try{
             
            DatagramSocket server = new DatagramSocket(12345);
            
            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            server.receive(packet);
            
            String msg = "Enviando mensagem do ServidorUDP para ClienteUDP...";
            buf = msg.getBytes();
             
            //Enviando a mensagem 
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf,buf.length, address, port);
            server.send(packet);
            
            /* 
            // Apenas como curiosidade
            System.out.println("------------------------");
            System.out.println("Address: " + packet.getAddress());
            System.out.println("Porta: " + packet.getPort());
            System.out.println("Mensagem: " +msg + "<---");
            System.out.println("Enviando pacote....");
            System.out.println("------------------------");
            */
            
            server.close();
            
         } catch (SocketException ex) {
             Logger.getLogger(ServerUDP.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         
     }
}
