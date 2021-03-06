package com.example.zombiesurvivor.modele;

import java.util.ArrayList;

public class Environnement {


    private ArrayList<Acteur> listperso;
    private ArrayList<Terrain> listTerrain ;
    private Terrain terrain;
    private Joueur personage;

    private enemieNv1 ennemie;
    private int width;
    private int height;

    public Environnement() {
        listperso = new ArrayList<>();
        listTerrain = new ArrayList<>();
        this.terrain = new Terrain();
        this.personage = new Joueur(350,162,null);
        this.ennemie = new enemieNv1(100,100,null);
        this.ajouterjoueur();
        this.ajouterterrain();
        this.ajouterEnnemie();
        this.ajouterEnnemie();
        this.width = 960;
        this.height = 640;
        System.out.println(terrain);
    }

    public void ajouterjoueur() {

        listperso.add(personage);
    }

    public void ajouterEnnemie() {

        listperso.add(ennemie);
    }

    public void ajouterterrain() {
        listTerrain.add(terrain);
    }

    public ArrayList<Acteur> getListperso() {
        return listperso;
    }

    @Override
    public String toString() {
        return "Environnement [listePerso=" + listperso + "listTerrain"+ listTerrain +"]";
    }

    public Joueur getPersonage() {
        return personage;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public enemieNv1 getEnnemie() {
        return ennemie;
    }
}
