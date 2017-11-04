package application;

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
            StringBuffer ipt = new StringBuffer(ipOrigem.getText().toString());
            if(ipt.length() == 0){
                try {
                    ipt.append(InetAddress.getLocalHost().getHostAddress());
                } catch (Exception e) {
                }
                ipt.append(":5555");
                ipOrigem.setText(ipt.toString());
            }else{
                String ip = ipDestino.getText();
                int pos = ip.indexOf(":");
                //ler a porta apos o :
                int porta = Integer.parseInt(ip.substring(pos+1));
                ip = ip.substring(0, pos);
            }
            origem.setText("Origem conectada:");
        }
        
        public void enviarEvento(ActionEvent evento){
            StringBuffer texto = new StringBuffer("");
            //gera a hora
            Date agora = new Date();
            SimpleDateFormat df = new SimpleDateFormat("H:mm ");
            texto.append(df.format(agora));
            texto.append("- eu:\n");
            texto.append(mensagem.getText());
            texto.append("\n\n");
            texto.append(lista.getText());
            lista.setText(texto.toString());
            String ip = ipDestino.getText();
            int pos = ip.indexOf(":");
            //ler a porta apos o :
            int porta = Integer.parseInt(ip.substring(pos+1));
            ip = ip.substring(0, pos);
            System.out.println("ip: "+ip);
            System.out.println("porta: "+porta);
            //cliente TCP
            try {
                Socket cliente = new Socket("127.0.0.1",5555);
                ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
                saida.flush();
                saida.writeObject(mensagem.getText());
                saida.close();
            }catch(IOException e) {
                System.out.println("Erro: " + e.getMessage());
            }finally{
                mensagem.clear();
            }
        }
	
}
