package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {

	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<>();
	}
	
	public void add(Voto v) {
		this.voti.add(v);
	}
	
	/*public void stampaVoti (int punteggio) {
		//libretto stampa da solo i voti
		System.out.println();
	}
	
	public String votiUguali(int punteggio) {
		//calcola una stringa che contiene voti, sarà poi il chiamante a stamparli
		
	}*/
	
	public List<Voto> listaVotiUguali(int punteggio) {
		//restituisce solo i voti uguali al criterio
		List<Voto> risultato = new ArrayList<>();
		for(Voto v: this.voti) {
			if(v.getVoto()==punteggio)
				risultato.add(v);
		}
		return risultato;
		
	}
	
	public Libretto votiUguali (int punteggio) {
		Libretto risultato = new Libretto();
			for (Voto v: this.voti) {
				if(v.getVoto()==punteggio) {
					risultato.add(v);
					//risultato.voti.add(v);
				}
			}
			return risultato;
	}
	
	public String toString() {
		String s = "";
		for(Voto v: this.voti ) {
			s= s + v.toString() + "\n";
		}
		return s;
	}
}
