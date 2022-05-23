package com.example.zombiesurvivor.modele;

public class Ressource extends Item {

	private int pv ;
	private int quantité ;
	
	public Ressource (int pv ) {
		this.pv = pv ;
		this.quantité = 0 ;
	}
	public int getPv() {
		return pv;
	}

	public int getQuantité() {
		return quantité;
	}

	public void augmente() {
		quantité += 10 ;

	}

	public void setQuantité (int quantité) {
		this.quantité = quantité;
	}

	@Override
	public String toString() {
		return "Ressource [Joueur a  +" + toString() +"]";
	}
	
	
}
