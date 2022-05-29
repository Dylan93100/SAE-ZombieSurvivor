package com.example.zombiesurvivor.modele;

import com.example.zombiesurvivor.vue.InventaireVue;
import com.example.zombiesurvivor.vue.JoueurVue;
import javafx.beans.property.IntegerProperty;

import java.util.ArrayList;

public class Environnement {


    private ArrayList<enemieNv1> listperso;
    private ArrayList<Viande> listeVache;
    private Viande vache;
    private Terrain terrain;
    private enemieNv1 ennemie;
    private Joueur personage;
    private InventaireVue inventaireVue;

    public Environnement() {
        listperso = new ArrayList<enemieNv1>();
        listeVache = new ArrayList<Viande>();
        this.terrain = new Terrain();
        this.personage = new Joueur(350,100,this);
        this.ajouterEnnemie();
        this.ajouterEnnemie();
        this.ajouterVache();
        System.out.println(terrain);
    }

    public IntegerProperty ennemieDeLaListeXproperty() {

        IntegerProperty a = null;
        for (int i = 0; i < listperso.size(); ++i) {
            a = listperso.get(i).xProperty();
        }
        return a;
    }

    public IntegerProperty vacheDeLaListeXproperty() {

        IntegerProperty a = null;
        for (int i = 0; i < listeVache.size(); ++i) {
            a = listeVache.get(i).XPropertyProperty();
        }
        return a;
    }


    public IntegerProperty ennemieDeLaListeYproperty() {

        IntegerProperty a = null;
        for (int i = 0; i < listperso.size(); ++i) {
            a = listperso.get(i).yProperty();
        }
        return a;
    }

    public IntegerProperty vacheDeLaListeYproperty() {

        IntegerProperty a = null;
        for (int i = 0; i < listeVache.size(); ++i) {
            a = listeVache.get(i).YPropertyProperty();
        }
        return a;
    }
    public void ennemieDeLaListeAgit(JoueurVue jou){

        for (int i = 0;i<listperso.size();++i){
            listperso.get(i).agir(jou);
        }
    }

    public void vacheDeLaListeAgit(){

        for (int i = 0;i<listeVache.size();++i){
            listeVache.get(i).agir();
        }
    }
    public void ajouterVache() {
        Viande vache = new Viande((int) aleatoire(),50,this);
        listeVache.add(vache);
    }



    public double aleatoire () {
            return Math.random()*940;
    }

    public void ennemieElimine(){

        for(int i = listperso.size()-1;i>=0;i--){
            System.out.println(listperso.get(i).getVie());
            if(listperso.get(i).estMort()){
                listperso.remove(i);
            }
        }
    }
    public void vacheEliminee (){

        for(int i = listeVache.size()-1;i>=0;i--){
            System.out.println(listeVache.get(i).getVie());
            if(listeVache.get(i).estMort()){
                personage.vache.augmente();
                listeVache.remove(i);
            }
        }
    }

    public void ajouterEnnemie() {
        enemieNv1 enemieNv1 = new enemieNv1((int) aleatoire(),50,this);
        listperso.add(enemieNv1);
    }

    public Viande getVache() {
        return vache;
    }

    public ArrayList<enemieNv1> getListperso() {
        return listperso;
    }

    public ArrayList<Viande> getListeVache () {
        return listeVache;
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
