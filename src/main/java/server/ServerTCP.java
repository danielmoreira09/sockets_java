/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class ServerTCP {
    
    public static void main(String[] args) throws IOException{
        
        try{
        // Abrindo porta 12345
        ServerSocket servidor = new ServerSocket(12345);
        Socket clientSocket = servidor.accept();
        System.out.println("Nova conexão com o cliente: "+clientSocket.getInetAddress().getHostAddress());
        
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);                   
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        out.println(in.readLine());
        }catch(IOException e){
            System.out.println("Erro: "+ e.getMessage());
        }
        
    }
}
