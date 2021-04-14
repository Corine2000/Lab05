package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Anagram;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Anagram model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtAreaAnagrammiCorretti;

    @FXML
    private TextArea txtAreaanagrammiErrrati;

    @FXML
    void doRicercaAnagrammi(ActionEvent event) {
    	
    	if(txtParola.getText().isEmpty()) {
    		txtAreaAnagrammiCorretti.setText("devi inserire una parola");
    		return;
    	}
    	
    	String parola = txtParola.getText();
    	model.anagrammi(parola);
     
    	String s1="";
    	for (String s: model.getAnagrammiCorretti()) {
    		s1+= s+"\n";
    	}
    	
    	String s2="";
    	for (String s: model.getAnagrammiErrati()) {
    		s2+= s+"\n";
    	}
    	txtAreaAnagrammiCorretti.setText(s1);
    	txtAreaanagrammiErrrati.setText(s2);
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	txtAreaAnagrammiCorretti.clear();
    	txtAreaanagrammiErrrati.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAreaAnagrammiCorretti != null : "fx:id=\"txtAreaAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAreaanagrammiErrrati != null : "fx:id=\"txtAreaanagrammiErrrati\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Anagram model) {
	  this.model=model;
		
	}
}
