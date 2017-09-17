package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class HomeController {

	private Label origem;
	private Label destino;
	private TextField ipOrigem;
	private TextField ipDestino;
	private ScrollPane sp;
	private VBox lista;
	private TextArea mensagem;
	private Button enviar;
	
	public HomeController() {
		super();
		this.origem = origem;
		this.destino = destino;
		this.ipOrigem = ipOrigem;
		this.ipDestino = ipDestino;
		this.sp = sp;
		this.lista = lista;
		this.mensagem = mensagem;
		this.enviar = enviar;
	}
	
}
