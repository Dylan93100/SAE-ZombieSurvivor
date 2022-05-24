package com.example.zombiesurvivor.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;

public class Ressource extends Item {

	private int pv ;
	private IntegerProperty quantité ;
	
	public Ressource (int pv ) {
		this.pv = pv ;
		quantité = new SimpleIntegerProperty();
	}
	public int getPv() {
		return pv;
	}

	public int getQuantité () {
		return quantité.get();
	}

	public IntegerProperty quantitéProperty () {
		return quantité;
	}

	public void augmente() {
		setQuantité(getQuantité()+10);;

	}

	public void setQuantité (int quantité) {
		this.quantité.set(quantité);
	}

	@Override
	public String toString() {
		return "Ressource [Joueur a    +" + toString() +"]";
	}
	
	
}
