package com.example.zombiesurvivor.modele;

public class Epee extends Equipement {

	public Epee() {
		super(7);
		// TODO Auto-generated constructor stub
	}
	public boolean Siepee(Equipement r) {
		if(r instanceof Epee) {
		}
		return true ;
	}
	@Override
	public String toString() {
		return "Epee";
	}
	
	
}
