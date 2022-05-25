package com.example.zombiesurvivor.modele;

import com.example.zombiesurvivor.vue.InventaireVue;

import java.util.ArrayList;

public class Environnement {


    private ArrayList<Acteur> listperso;
    private ArrayList<Ressource> listeVache;
    private Viande vache;
    private Terrain terrain;
    private enemieNv1 ennemie;
    private Joueur personage;
    private InventaireVue inventaireVue;

    public Environnement() {
        listperso = new ArrayList<>();

        listeVache = new ArrayList<>();
        this.terrain = new Terrain();
        this.personage = new Joueur(350,100,this);
        this.ennemie = new enemieNv1(350,100,this);
        this.vache = new Viande(366,322,this);
        this.ajouterjoueur();
        this.ajouterEnnemie();
        this.ajouterEnnemie();
        this.ajouterVache();
        System.out.println(terrain);
    }

    public void ajouterjoueur() {

        listperso.add(personage);
    }

    public void ajouterVache() {

        listeVache.add(vache);
    }

    public void ajouterEnnemie() {

//        listperso.add(ennemie);
    }

    public Viande getVache() {
        return vache;
    }

    public ArrayList<Acteur> getListperso() {
        return listperso;
    }

    @Override
    public String toString() {
        return "Environnement [listePerso=" + listperso + "listTerrain"+ terrain +"]";
    }

    public Joueur getPersonage() {
        return personage;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public enemieNv1 getEnnemie () {
    return ennemie;
    }

//    public enemieNv1 getEnnemie() {
//        return ennemie;
//    }
}
