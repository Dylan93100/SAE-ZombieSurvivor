package com.example.zombiesurvivor.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Ressource extends Item {

	int vie;
	private IntegerProperty quantité ;
	
	public Ressource (int pv ) {
		this.vie = pv ;
		quantité = new SimpleIntegerProperty();
	}
	public int getVie () {
		return vie;
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

//	@Override
//	public String toString() {
//		return "Ressource [Joueur a    +" + toString() +"]";
//	}
	
	
}
