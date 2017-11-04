/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author beltraoluis
 */
public class ServidorTCP {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            // Instancia o ServerSocket ouvindo a porta 5555
            ServerSocket servidor = new ServerSocket(5555);
            System.out.println("Servidor ouvindo a porta 5555");
            while(true) {
                // o método accept() bloqueia a execução até que
                // o servidor receba um pedido de conexão
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
                ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
                String mensagem = (String)entrada.readObject();
                entrada.close();
                System.out.println(mensagem);
                cliente.close();
            }  
        }   
        catch(IOException e) {
           System.out.println("Erro: " + e.getMessage());
        }
    }
}
