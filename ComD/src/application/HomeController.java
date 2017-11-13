package application;

import beltraoluis.conexao.AMI;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class HomeController {

    private boolean conectado = false;
    private ServidorTCP servidor;
    @FXML
    private Label origem;
    private Label destino;
    @FXML
    private TextField ipOrigem;
    @FXML
    private TextField ipDestino;
    private ScrollPane sp;
    @FXML
    private TextArea lista;
    @FXML
    private TextArea mensagem;
    private Button enviar;
    private Button conectar;
        
    public void conectarEvento(ActionEvent evento){
        int porta = 5555;
        // tratar ip fazio
        StringBuffer ipt = new StringBuffer(ipOrigem.getText().toString());
        if(ipt.length() == 0){
            try {
                ipt.append("127.0.0.1");
            } catch (Exception e) {
            }
            ipt.append(":");
            ipt.append(porta);
            ipOrigem.setText(ipt.toString());
        }else{
            String ip = ipOrigem.getText();
            int pos = ip.indexOf(":");
            System.out.println(ip.substring(pos+1));
            //ler a porta apos o :
            porta = Integer.parseInt(ip.substring(pos+1));
        }
        if(!conectado){
            servidor = new ServidorTCP(this, porta);
            origem.setText("Origem conectada:");
            conectado = !conectado;
        }/*else{
            servidor.parar();
            servidor = null;
            servidor = new ServidorTCP(this, porta);
            origem.setText("Origem:");
        }*/
    }
        
    public void enviarEvento(ActionEvent evento){
        String ip = ipDestino.getText();
        int pos = ip.indexOf(":");
        //ler a porta apos o :
        int porta = Integer.parseInt(ip.substring(pos+1));
        ip = ip.substring(0, pos);
        //System.out.println("ip: "+ip);
        //System.out.println("porta: "+porta);
        //cliente TCP
        try {
            Socket cliente = new Socket(ip,porta);
            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
            AMI linha = new AMI();
            linha.codificar(mensagem.getText());
            saida.flush();
            saida.writeObject(linha);
            saida.close();
        }catch(IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            atualizar("eu", mensagem.getText());
            mensagem.clear();
        }
    }
        
    public void atualizar(String remetente, String mensagem){
        StringBuffer texto = new StringBuffer("");
        //gera a hora
        Date agora = new Date();
        SimpleDateFormat df = new SimpleDateFormat("H:mm ");
        texto.append(df.format(agora));
        texto.append("- ");
        texto.append(remetente);
        texto.append(":\n");
        texto.append(mensagem);
        texto.append("\n\n");
        texto.append(lista.getText());
        lista.setText(texto.toString());
    }
	
}
