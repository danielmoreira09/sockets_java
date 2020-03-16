/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class ServerUDP {
     public static void main(String[] args) throws IOException{
         
         try {
             
            DatagramSocket server = new DatagramSocket(12345);
            byte[] receptor = new byte[1024];
            DatagramPacket bufferRecebimento = new DatagramPacket(receptor, receptor.length);
            server.receive(bufferRecebimento);
            
            String msg = new String(bufferRecebimento.getData());
            System.out.println(msg);
             
            DatagramPacket bufferEnvio = new DatagramPacket(receptor, receptor.length, bufferRecebimento.getAddress(),bufferRecebimento.getPort());
            server.send(bufferEnvio);
            server.close();
            
         } catch (SocketException ex) {
             Logger.getLogger(ServerUDP.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         
     }
}
