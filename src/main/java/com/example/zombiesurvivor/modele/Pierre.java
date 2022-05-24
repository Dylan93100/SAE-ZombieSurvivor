package com.example.zombiesurvivor.modele;

public class Pierre extends Ressource {

	public Pierre() {
		super(1);
	}


	public boolean SiPierre(Ressource r) {
		if(r instanceof Pierre) {
		}
			return true ;
	}
	@Override
	public String toString() {
		return "Pierre [" + super.getQuantité() ;
	}

}
