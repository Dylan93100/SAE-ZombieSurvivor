package com.example.zombiesurvivor.modele;

import com.example.zombiesurvivor.vue.JoueurVue;
import javafx.scene.image.ImageView;

public class Joueur extends Acteur{

    public Joueur (int x,int y,Environnement env) {
        super(5,2,5,3,x,y,env);
    }

    public void seDelaceDroite () {
        int xDest = this.xProperty().getValue() + getVitesse();
            if (this.terrain.tuileTraversable(xDest + 27, getY())) {
                this.setX(xDest);
            }
    }

    @Override
    public void seDeplaceDroite () {

    }

    public void seDeplaceGacuhe () {
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


//public void attasueOutil() {
//
//}
//public void craftEpee (){
//
//   Epee p;
//
//    if(inventaire.getBois==10 && inventaire.getPierre==10 ){
//        inventaire.add(p);
//        }
//    }
//    public void craftBotte (){
//        Botte b;
//        if(inventaire.getCuire==10 ){
//            inventaire.add(b);
//        }
//    }
//    public void craftLancepierre (){
//        LanceFlamme l;
//        if(inventaire.getBois==10 && inventaire.getPierre==10 && inventaire.getCuire==10 ){
//            inventaire.add(l);
//        }
//    }
//    public void craftclee (){
//        Clee c;
//        if(inventaire.getBois==10 && inventaire.getPierre==10 && inventaire.getCuire==10){
//            inventaire.add(c);
//        }
//}
//
//
//

