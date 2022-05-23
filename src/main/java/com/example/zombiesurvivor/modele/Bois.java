package com.example.zombiesurvivor.modele;

public class Bois extends Ressource {

	public Bois() {
		super(1);
	}
	
	
	
	@Override
	public String toString() {
		return "Bois [" + super.getQuantité() ;
	}
	
	public boolean siBois(Ressource r) {
		if(r instanceof Bois) {
			return true ;

		}
		return false ;
	}
	
}
