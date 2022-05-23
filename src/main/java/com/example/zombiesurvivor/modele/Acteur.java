package com.example.zombiesurvivor.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Acteur {
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

    public Acteur (int vie, int vitesse, int attaque, int saut, int x, int y, Environnement env) {
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

    public boolean isGravite () {
        return gravite;
    }

    public void verifGravite () {
        if (!terrain.tuileSol(this.getX(), this.getY() + 32)) {
            this.gravite = true;
        }
        else {
            this.gravite = false;
        }
    }

    public Terrain getTerrain () {
        return terrain;
    }

    public Environnement getEnv () {
        return env;
    }

    public int getX () {
        return XProperty.get();
    }

    public int getY () {
        return YProperty.get();
    }

    public void setX (int newX) {
        XProperty.setValue(newX);
    }

    public static IntegerProperty xProperty () {
        return XProperty;
    }

    public IntegerProperty yProperty () {
        return YProperty;
    }

    public int getVitesse () {
        return vitesse;
    }

    public void setVitesse (int vitesse) {
        this.vitesse = vitesse;
    }

    public int getSaut () {
        return saut;
    }

    public void setSaut (int saut) {
        this.saut = saut;
    }

    public void setyValue (int n) {
        this.yProperty().setValue(this.yProperty().getValue() - n);
    }

    public static void setxValue (int n) {
        xProperty().setValue(xProperty().getValue() - n);
    }

    public int getVie () {
        return vie;
    }

    public int getAttaque () {
        return attaque;
    }

    public void enleveVie (Acteur m) {
        m.vie -= this.attaque;
    }

    public void gravity () {
        if (this.yProperty().getValue() != terrain.codesTuiles[2]) {
            this.yProperty().setValue(this.yProperty().getValue() + 5);
        }
    }

    public boolean estMort () {
        return this.vie <= 0;
    }

    public boolean estVivant () {
        return this.vie > 0;
    }

    public static void limitationMapX () {
        if (Acteur.xProperty().getValue() > 935) {
                Acteur.setxValue(3);
                System.out.println("Vous avez atteint la limte de la map");
        }
        if (Acteur.xProperty().getValue() < -5) {
                Acteur.setxValue(-3);
                System.out.println("Vous avez atteint la limte de la map");
        }
    }

    public static void colis () {
        if (Acteur.xProperty().getValue() == 29112 || Acteur.xProperty().getValue() == 29120){
            Acteur.setxValue(Acteur.xProperty().getValue() - 1);
        }
    }

    public abstract void seDeplaceDroite ();
    public abstract void seDeplaceGacuhe ();
    public abstract void seDeplaceHaut ();
}
