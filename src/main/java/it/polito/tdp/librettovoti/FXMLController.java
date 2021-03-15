package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
    
	private Libretto model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txEsame;

    @FXML
    private TextField txVoto;

    @FXML
    private TextField txData;

    @FXML
    private TextArea txResult;

    @FXML
    void handleInserisci(ActionEvent event) {
    	//Leggi e controlla  dati
    	String nomeEsame = txEsame.getText();
    	String votoEsame = txVoto.getText();
    	int votoInt = Integer.parseInt(votoEsame);
    	String dataEsame = txData.getText();
    	LocalDate data = LocalDate.parse(dataEsame);
    	
    	//Esegui l'azione
    	Voto voto = new Voto(nomeEsame, votoInt, data);
    	model.add(voto);
    	
    	//Aggiorna i risultati nella View
    	txResult.setText(model.toString());
    }
    
    public void setModel(Libretto model) {
    	this.model = model;
    }

    @FXML
    void initialize() {
        assert txEsame != null : "fx:id=\"txEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txVoto != null : "fx:id=\"txVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txData != null : "fx:id=\"txData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txResult != null : "fx:id=\"txResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
