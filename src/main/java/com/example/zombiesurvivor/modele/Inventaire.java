package com.example.zombiesurvivor.modele;

import java.util.ArrayList;

public class Inventaire {
    public ArrayList<Equipement> lesEquipements;
    public ArrayList<Ressource> lesRessources;

    public Inventaire () {
        lesEquipements  = new ArrayList<>();
        lesRessources = new ArrayList<>();
    }

    public ArrayList<Equipement> getEquipInv() {
        return lesEquipements;
    }

    public ArrayList<Ressource> getResInv() {
        return lesRessources;
    }

    public void ajouterRess(Ressource r) {
        lesRessources.add(r);
    }
    public void ajouterEquip(Equipement e) {
        lesEquipements.add(e);
    }

    @Override
    public String toString() {
        return "Inventaire [InvEquipements=" + lesEquipements + ",InvRessources=" + lesRessources + "]";
    }
}