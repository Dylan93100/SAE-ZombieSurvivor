package com.example.zombiesurvivor.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class  Acteur {
    protected static IntegerProperty XProperty;
    protected static IntegerProperty YProperty;
    private int vie;
    private int vitesse;
    private int y;
    private int x;
    private int attaque;
    private int saut;
    private Environnement env;
    protected Terrain terrain;
    private boolean gravite;

    public Acteur (int vie, int vitesse, int attaque, int saut,int x,int y, Environnement env){
        this.vie = vie;
        this.vitesse = vitesse;
        this.attaque = attaque;
        this.saut = saut;
        this.x = x;
        this.y = y;
        XProperty = new SimpleIntegerProperty(x);
        YProperty = new SimpleIntegerProperty(y);
        this.env = env;
        this.terrain = new Terrain();
        this.env = env;
    }

    public boolean isGravite() {
        return gravite;
    }

    public void verifGravite() {
        if(!terrain.tuileSol(this.getX(), this.getY()+32)) {
            this.gravite = true;
        }
        else {
            this.gravite =false;
        }
    }
    public Terrain getTerrain() {
        return terrain;
    }

    public Environnement getEnv() {
        return env;
    }

    public int getX () {
        return XProperty.get();
    }

    public int getY () {
        return YProperty.get();
    }

    public void setX(int newX)  {
        XProperty.setValue(newX);
    }

    public IntegerProperty xProperty() {
        return XProperty;
    }

    public IntegerProperty yProperty () {
        return YProperty;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public int getSaut() {
        return saut;
    }

    public void setyValue(int n ) {
        this.yProperty().setValue(this.yProperty().getValue()-n);
    }

    public void setxValue(int n) {
        this.xProperty().setValue(this.xProperty().getValue()-n);
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public void changeVie(int degat) {
        setVie(getVie()-degat);
    }

    public int getAttaque() {
        return attaque;
    }

    public void enleveVie(enemieNv1 m) {
        m.vie-=this.attaque;
    }

    public boolean estMort (){
        return this.vie<=0;
    }

    public boolean estVivant (){
        return this.vie>0;
    }

    public void limitationMapX() {
        if(this.xProperty().getValue()>935) {
            this.setxValue(5);
            System.out.println("Vous avez atteint la limte de la map");
        }
        if(this.xProperty().getValue()<-5) {
            this.setxValue(-5);
            System.out.println("Vous avez atteint la limte de la map");
        }
    }

    public abstract void seDeplpaceDroite();

    public abstract void seDeplpaceGacuhe ();

    public abstract void agir();

}


//    public void attaqueAlaMain(){
//    for(Acteur m : this.terrain.getActeurs()){
//
//            if
//            (		(this.getY()-1<= m.getY() && m.getY()<=this.getY()+1) &&
//                    (this.getX()-2<= m.getX() && m.getX()<=this.getX()+2)
//            )
//            {
//                this.enleveVie(m);
//        }
//    }
//}
