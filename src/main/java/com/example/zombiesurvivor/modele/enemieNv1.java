package com.example.zombiesurvivor.modele;

import com.example.zombiesurvivor.vue.JoueurVue;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class enemieNv1  {
    int vie;
    private int vitesse;
    private int attaque;
    private int saut;

    private  Terrain terrain;
    boolean gravite;

private Environnement env;
    private IntegerProperty xProperty;
    private IntegerProperty yProperty;
    //private Joueur m;
    public enemieNv1(int x ,int y,Environnement env) {

        vie = 5;
         vitesse = 2;
         attaque = 2;
         saut = 2;
         terrain = new Terrain();
       this.env = env;
        this.xProperty = new SimpleIntegerProperty(x);
        this.yProperty = new SimpleIntegerProperty(y);

    }

    public boolean isGravite() {
        return gravite;
    }

    public void verifGravite() {
        if (!terrain.tuileSol(this.getX(), this.getY() + 32)) {
            this.gravite = true;
        } else {
            this.gravite = false;
        }
    }

    public void setyValue(int n ) {
        this.yProperty().setValue(this.yProperty().getValue()-n);
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

    public int getVie () {
        return vie;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setX(int xProperty) {
        this.xProperty.set(xProperty);
    }


    public void agir(JoueurVue jou) {

        verifGravite();
        isGravite();
        avancerDroite(jou);
        avancerGauche(jou);
        if (isGravite()) {
            setyValue(-3);
            verifGravite();
        }
    }

    public  void avancerDroite(JoueurVue jou){
           isGravite();
            if (Math.random() * 4 > 2) {
        int xDest = this.xProperty().getValue() + getVitesse();
        if (this.env.getTerrain().tuileTraversable(getX() + 27, getY())) {
            this.setX(xDest);
            attaqueDroit(jou);
        }
      }else{
                avancerGauche(jou);
            }
    }

    public void avancerGauche(JoueurVue jou){
     if (Math.random() * 4 > 2) {
        int yDest = this.xProperty().getValue() - getVitesse();
        if (this.env.getTerrain().tuileTraversable(getX() + 5, getY())) {
            this.setX(yDest);
            attaqueGauche(jou);
        }
        else{
            avancerDroite(jou);
        }
    }

    }



    public void enleveVie(Joueur personage) {
        personage.changeVie(attaque);
    }
    public void attaqueDroit(JoueurVue jou){

            if(this.getY()-5<= env.getPersonage().getY() && env.getPersonage().getY()<=this.getY()+5 &&this.getX()-37<= env.getPersonage().getX() && env.getPersonage().getX()<=this.getX()+5) {
                enleveVie(getEnv().getPersonage());
        }
        if(getEnv().getPersonage().estMort()) {
            jou.imageMort();
        }
            }
    public void attaqueGauche(JoueurVue jou) {

        if (this.getY() - 5 <= env.getPersonage().getY() && env.getPersonage().getY() <= this.getY() + 5 && this.getX() - 5 <= env.getPersonage().getX() && env.getPersonage().getX() <= this.getX() + 37) {
            enleveVie(getEnv().getPersonage());
        }
        if (getEnv().getPersonage().estMort()) {
            // jou.imageMort();
        }
    }

    public boolean estMort(){

        return vie<=0 ;
    }

    public void BFS(){

    }
}

