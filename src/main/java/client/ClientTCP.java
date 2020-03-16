/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 
 * @author daniel
 */

public class ClientTCP {
    public static void main(String[] args){
    
        //calculando tempo
        long tempoInicial = System.currentTimeMillis();

        try {
            Socket client = new Socket("127.0.0.1", 12345);
            
            //enviando
            OutputStream enviaAoServidor = client.getOutputStream();
            DataOutputStream dos = new DataOutputStream(enviaAoServidor);
            //dos.write(65);
            dos.writeBytes("Enviando Mensagem");
            
            //recebendo
            InputStream is = client.getInputStream();
            System.out.println("Recebendo do Servidor: "+(char)is.read());
            //System.out.println("Recebendo do Servidor: "+(char)is.read());
            
            client.close();
            
            long tempoFinal = System.currentTimeMillis();
            System.out.printf("%.9f ms", (double)(tempoFinal - tempoInicial) / 1000L);
        
            
        }catch(Exception e){

        }
    }
}