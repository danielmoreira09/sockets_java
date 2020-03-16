/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class ServerTCP {
    
    public static void main(String[] args) throws IOException{
        
        // Abrindo porta 12345
        ServerSocket servidor = new ServerSocket(12345);
        
        //recebendo
        Socket conexao = servidor.accept();
        System.out.println("Nova conexão com o cliente: "+conexao.getInetAddress().getHostAddress());
        
        Scanner s = new Scanner(conexao.getInputStream());
        while(s.hasNextLine())
            System.out.println(s.nextLine());
        /*
        InputStream is = conexao.getInputStream();
        System.out.println("Recebido do Cliente: "+(char) is.read());
        */
        
        //enviando
        OutputStream enviaAoCliente = conexao.getOutputStream();
        DataOutputStream dos = new DataOutputStream(enviaAoCliente);
        dos.write(66);
        //dos.write(66);
        
        s.close();
        servidor.close();
        conexao.close();
    }
}
