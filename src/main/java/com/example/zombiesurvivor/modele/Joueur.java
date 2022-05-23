package com.example.zombiesurvivor.modele;

import com.example.zombiesurvivor.vue.JoueurVue;
import javafx.scene.image.ImageView;

public class Joueur extends Acteur{


    public Joueur (int x,int y,Environnement env) {
        super(5,2,5,3,x,y,env);
    }

    public void seDeplaceDroite () {
        int xDest = this.xProperty().getValue() + getVitesse();
            if (this.terrain.tuileTraversable(xDest + 27, getY())) {
                this.setX(xDest);
            }
    }

    public void seDeplaceGauche () {
        int yDest = this.xProperty().getValue() - getVitesse();
            if (this.terrain.tuileTraversable(getX() + 5, getY())) {
                this.setX(yDest);
                System.out.println(xProperty().getValue());
            }
    }

    @Override
    public void seDeplaceHaut () {
           this.yProperty().setValue(this.yProperty().getValue() - getSaut() * 2);
    }
}