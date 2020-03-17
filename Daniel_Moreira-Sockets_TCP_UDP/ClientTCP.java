/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 * @author daniel
 */

public class ClientTCP {
    public static void main(String[] args){
    
        // Tempo Inicial
        long tempoInicial = System.currentTimeMillis();

        try {
            Socket client = new Socket("127.0.0.1", 12345);
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            out.println("Enviando mensagem do Cliente para o Servidor...");
            System.out.println("Mensagem recebida do Servidor --> " + in.readLine() +" <--");
            
            client.close();
            long tempoFinal = System.currentTimeMillis();
            System.out.printf("%.9f ms", (double)(tempoFinal - tempoInicial) / 1000L);
            
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
}