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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author beltraoluis
 */
public class ServidorTCP extends Thread {
    
    protected HomeController control;
    protected int porta;
    protected boolean executar;
    protected ServerSocket servidor;
    
    public ServidorTCP(HomeController control, int porta){
        this.control = control;
        this.porta = porta;
        executar = true;
        this.start();
    }
    
    public void run(){
        try {
            // Instancia o ServerSocket ouvindo a porta 5555
            servidor = new ServerSocket(porta);
            System.out.println("Servidor ouvindo a porta " + porta);
            control.atualizar("Servidor", "Servidor ouvindo a porta " + porta);
            while(executar) {
                // o método accept() bloqueia a execução até que
                // o servidor receba um pedido de conexão
                Socket cliente = servidor.accept();
                String ipCliente = cliente.getInetAddress().getHostAddress();
                System.out.println("Cliente conectado: " + ipCliente);
                ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
                String mensagem = (String)entrada.readObject();
                entrada.close();
                try {
                    this.sleep(200);
                } catch (InterruptedException ex) {
                }
                control.atualizar(ipCliente, mensagem);
                cliente.close();
            }  
        }   
        catch(IOException e) {
           System.out.println("Erro: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void parar(){
        try {
            servidor.close();
        } catch (IOException ex) {
        }
        executar = false;
        this.interrupt();
    }
}
