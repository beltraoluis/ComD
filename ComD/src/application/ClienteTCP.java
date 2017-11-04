/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author beltraoluis
 */
public class ClienteTCP {
    public static void main(String[] args) {
        try {
            Socket cliente = new Socket("127.0.0.1",5555);
            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
            saida.flush();
            saida.writeObject("isso foi a menssagem");
            saida.close();
          }
        catch(IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
  }
}
