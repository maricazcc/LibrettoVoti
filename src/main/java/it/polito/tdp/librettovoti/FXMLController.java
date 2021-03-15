package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
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
    private DatePicker pickerEsame;

    @FXML
    private TextArea txResult;

    @FXML
    void handleInserisci(ActionEvent event) {
    	//Leggi e controlla  dati
    	String nomeEsame = txEsame.getText();
    	if(nomeEsame.length()==0) {
    		txResult.setText("ERRORE: nome esame vuoto");
    		return;
         }
    	
    	String votoEsame = txVoto.getText();
    	int votoInt = 0;
    	try {
    	     votoInt = Integer.parseInt(votoEsame);
    	} catch(NumberFormatException ex ) {
    		txResult.setText("ERRORE: il voto deve essere numerico");
    		return;
    	}
    	if(votoInt<18 || votoInt>30) {
    		txResult.setText("ERRORE: il voto deve essere compreso tra 18 e 30");
    		return;
    	}
    	
    /*	String dataEsame = txData.getText();
    	LocalDate data;
    	try {
    	     data = LocalDate.parse(dataEsame);
   	} catch(DateTimeParseException ex ) {
   		txResult.setText("ERRORE: la data non è nel formato corretto ");
   		return;
   	} */
    	LocalDate data = pickerEsame.getValue();
    	if(data==null) {
    		txResult.setText("ERRORE: la data è obbligatoria");
    		return;
    	}
    	
    	//Esegui l'azione
    	Voto voto = new Voto(nomeEsame, votoInt, data);
    	model.add(voto);
    	
    	//Aggiorna i risultati nella View
    	txResult.setText(model.toString());
    	txEsame.clear();
    	txVoto.clear();
    	pickerEsame.setValue(null);
    	
    }
    
    public void setModel(Libretto model) {
    	this.model = model;
    }

    @FXML
    void initialize() {
        assert txEsame != null : "fx:id=\"txEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txVoto != null : "fx:id=\"txVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert pickerEsame != null : "fx:id=\"pickerEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txResult != null : "fx:id=\"txResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
