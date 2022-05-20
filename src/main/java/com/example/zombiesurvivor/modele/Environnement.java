package com.example.zombiesurvivor.modele;

import java.util.ArrayList;

public class Environnement {


    private ArrayList<Acteur> listperso;
    private ArrayList<Terrain> listTerrain ;
   private Terrain terrain;
    private Joueur personage;
    private int width;
    private int height;

    public Environnement() {
        listperso = new ArrayList<>();
        listTerrain = new ArrayList<>();
        this.terrain = new Terrain();
        this.personage = new Joueur(terrain);
        this.ajouterjoueur();
        this.ajouterterrain();
        this.width = 960;
        this.height = 640;
    }

    public void ajouterjoueur() {

        listperso.add(personage);
    }

    public void ajouterterrain() {
        listTerrain.add(terrain);
    }


    @Override
    public String toString() {
        return "Environnement [listePerso=" + listperso + "listTerrain"+ listTerrain +"]";
    }

    public Joueur getPersonage() {
        return personage;
    }

}
