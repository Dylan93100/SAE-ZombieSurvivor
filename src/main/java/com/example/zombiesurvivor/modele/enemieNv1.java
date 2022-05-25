package com.example.zombiesurvivor.modele;

import com.example.zombiesurvivor.vue.JoueurVue;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class enemieNv1  {
private int vie;
    private int vitesse;
    private int attaque;
    private int saut;

private Environnement env;
    private IntegerProperty xProperty;
    private IntegerProperty yProperty;
    //private Joueur m;
    public enemieNv1(int x ,int y,Environnement env) {

        vie = 5;
         vitesse = 2;
         attaque = 2;
         saut = 2;
       this.env = env;
        this.xProperty = new SimpleIntegerProperty(x);
        this.yProperty = new SimpleIntegerProperty(y);

    }

    public Environnement getEnv() {
        return env;
    }

    public int getX() {
        return xProperty.get();
    }

    public IntegerProperty xProperty() {
        return xProperty;
    }

    public int getY() {
        return yProperty.get();
    }

    public IntegerProperty yProperty() {
        return yProperty;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setX(int xProperty) {
        this.xProperty.set(xProperty);
    }

    public void seDeplpaceDroite() {
        if (Math.random() * 4 > 2) {
            int xDest = this.xProperty().getValue() + getVitesse();
            if (this.env.getTerrain().tuileTraversable(getX() + 27, getY())) {
                this.setX(xDest);
            }
        }
    }



    public void seDeplpaceGacuhe() {
        if (Math.random() * 4 > 2) {
            int yDest = this.xProperty().getValue() - getVitesse();
            if (this.env.getTerrain().tuileTraversable(getX() + 5, getY())) {
                this.setX(yDest);
            }
        }
    }


    //public void agir () {

  //  }


    public void enleveVie(Joueur personage) {
        personage.changeVie(attaque);
    }
    public void attaque(JoueurVue jou){


        //for (int i = 0;i==env.getListperso().size();i++){
            if((getEnv().getPersonage().getX()+5<= getEnv().getEnnemie().getX() && getEnv().getPersonage().getY()-50<= getEnv().getEnnemie().getX())){
                enleveVie(getEnv().getPersonage());
            System.out.println(getEnv());
        }
        if(getEnv().getPersonage().estMort()) {
            jou.imageMort();
        }
            }
        //}


    public void BFS(){

    }
}

