package com.example.zombiesurvivor.modele;

import java.util.ArrayList;

public class Inventaire {
	public ArrayList<Equipement> equipInv;
	public ArrayList<Ressource> resInv;
	
	public Inventaire () {
		equipInv  = new ArrayList<>();
		resInv  = new ArrayList<>();
	}

	public ArrayList<Equipement> getEquipInv() {
		return equipInv;
	}

	public ArrayList<Ressource> getResInv() {
		return resInv;
	}
	
	public void ajouterRess(Ressource r) {
		resInv.add(r);
	}
	public void ajouterEquip(Equipement e) {
		equipInv.add(e);
	}

	@Override
	public String toString() {
		return "Inventaire [InvEquipements=" + equipInv + ",InvRessources=" + resInv + "]";
	}

}
