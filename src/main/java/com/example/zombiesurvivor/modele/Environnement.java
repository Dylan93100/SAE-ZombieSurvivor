package com.example.zombiesurvivor.modele;

import java.util.ArrayList;

public class Environnement {


    private ArrayList<Acteur> acteurs;
    private Terrain terrain;
    private EnemieNv1 ennemie;
    private Joueur personage;

    public Environnement() {
        acteurs = new ArrayList<>();
        this.terrain = new Terrain();
        this.personage = new Joueur(350,100,this);
        this.ennemie = new EnemieNv1(350,100,this);
        this.ajouterjoueur();
        this.ajouterEnnemie();
    }

    public void ajouterjoueur() {
        acteurs.add(personage);
    }
    
    public void ajouterEnnemie() {
       acteurs.add(ennemie);
    }


    public ArrayList<Acteur> getActeurs() {
        return acteurs;
    }
    
    public Joueur getPersonage() {
        return personage;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public EnemieNv1 getEnnemie () {
    return ennemie;
    }

    @Override
    public String toString() {
        return "Environnement [listePerso=" + acteurs + "listTerrain"+"]";
    }

}
