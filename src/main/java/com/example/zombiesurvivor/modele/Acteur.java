package com.example.zombiesurvivor.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class  Acteur {
    protected static IntegerProperty XProperty;
    protected static IntegerProperty YProperty;
    private int vie;
    private int vitesse;
    private int attaque;
    private int saut;
    protected Terrain terrain;
    private boolean gravite;


    public Acteur (int vie, int vitesse, int attaque, int saut,Terrain terrain){
        this.vie = vie;
        this.vitesse = vitesse;
        this.attaque = attaque;
        this.saut = saut;
        XProperty = new SimpleIntegerProperty(350);
        YProperty = new SimpleIntegerProperty(162);
        this.terrain = terrain;
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

    public void collesionGauche() {

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


    public static IntegerProperty xProperty () {
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

    public void setSaut(int saut) {
        this.saut = saut;
    }

    public void setyValue(int n ) {
        this.yProperty().setValue(this.yProperty().getValue()-n);
    }

    public static void setxValue(int n ) {
        xProperty().setValue(xProperty().getValue()-n);
    }

    public int getVie() {
        return vie;
    }

    public int getAttaque() {
        return attaque;
    }

    public void enleveVie(Acteur m) {

        vie=-attaque;

    }

    public void gravity() {
        if(this.yProperty().getValue()!=terrain.codesTuiles[2]) {
            this.yProperty().setValue(this.yProperty().getValue()+5);
        }
    }


    public boolean estMort (){
        return this.vie<=0;
    }
    public boolean estVivant (){
        return this.vie>0;
    }

    public static void limitationMapX() {
        if(Acteur.xProperty().getValue()>935) {
            Acteur.setxValue(3);
            System.out.println("Vous avez atteint la limte de la map");
        }
        if(Acteur.xProperty().getValue()<-5) {
            Acteur.setxValue(-3);
            System.out.println("Vous avez atteint la limte de la map");
        }
    }

    public static void colis() {
        if(Acteur.xProperty().getValue() ==  29112 || Acteur.xProperty().getValue() ==29120)
            Acteur.setxValue(Acteur.xProperty().getValue()-1);

    }



    public abstract void seDeplpaceDroite();
    public abstract void seDeplpaceGacuhe ();
    public abstract void seDeplpaceHaut ();

}
//	public Terrain getTerrain() {
//		return terrain;
//	}

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

//public void gravite (){
//
//	while(this.YProperty.this.getCodesTuile() != 2) {
//			this.YProperty.setValue(YProperty.getValue()-1);
//	}
//}
