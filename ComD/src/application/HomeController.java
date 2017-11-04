package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	private VBox lista;
        @FXML
	private TextArea mensagem;
	private Button enviar;
        private Button conectar;
        	
	public void conectarEvento(ActionEvent evento){
            origem.setText("Origem conectada:");
        }
	
}
