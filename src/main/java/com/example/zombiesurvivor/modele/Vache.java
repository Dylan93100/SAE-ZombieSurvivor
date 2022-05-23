package com.example.zombiesurvivor.modele;

public class Vache extends Ressource {

	public Vache () {
		super(5);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "vache [" + super.getQuantité() ;
	}
	
	public boolean SiTerre(Ressource r) {
		if(r instanceof Vache) {
			return true ;
		}
		return false ;
	}
}
