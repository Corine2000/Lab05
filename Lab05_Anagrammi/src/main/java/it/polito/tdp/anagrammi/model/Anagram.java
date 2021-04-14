package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagramDAO;

public class Anagram {
	
	/*
	 * 
	 * questa classe deve implementare l'algoritmo ricorsivo
	 */
	
	AnagramDAO anagrammo;
	List<String> AnagrammiCorretti;
	List<String> AnagrammiErrati;
	
	public Anagram() {
		anagrammo = new AnagramDAO();
		AnagrammiCorretti = new ArrayList<>();
		AnagrammiErrati = new ArrayList<>();
		
	}
	
	public void anagrammi(String parola) {
		
		permuta(parola,"",0);
	}
	
	public void permuta(String lettere, String parziale, int livello) {
		if(lettere.length()==0) { //caso terminale
			
			if(anagrammo.isCorrect(parziale)) {
				AnagrammiCorretti.add(parziale);
			}else {
				AnagrammiErrati.add(parziale);
			}
			
		}else {
			//costruiamo la nosta soluzione parziale
			
			for(int i=0; i<lettere.length(); i++) {
				char carattere= lettere.charAt(i);
				
				String NuovaParziale = parziale+carattere;
				String NuovaLettere = lettere.substring(0, i) + lettere.substring(i+1);
				
				permuta(NuovaParziale,NuovaLettere,livello+1);
			}
			
		}
		
	}

	public List<String> getAnagrammiCorretti() {
		return AnagrammiCorretti;
	}

	

	public List<String> getAnagrammiErrati() {
		return AnagrammiErrati;
	}

	
	
	

}
