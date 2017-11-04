package application;

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
            String ip = ipOrigem.getText();
            origem.setText("Origem conectada:");
        }
        
        public void enviarEvento(ActionEvent evento){
            Date agora = new Date();
            SimpleDateFormat df = new SimpleDateFormat("H:mm ");
            StringBuffer texto = new StringBuffer("");
            texto.append(df.format(agora));
            texto.append("- eu:\n");
            texto.append(mensagem.getText());
            texto.append("\n\n");
            texto.append(lista.getText());
            lista.setText(texto.toString());
            mensagem.clear();
        }
	
}
