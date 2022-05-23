package com.example.zombiesurvivor.modele;

<<<<<<< HEAD
=======

import com.example.zombiesurvivor.vue.JoueurVue;
import javafx.scene.image.ImageView;

>>>>>>> origin/merge
public class Joueur extends Acteur{
    //ArrayList<Inventaire> inventaire = new ArrayList<Inventaire>();

    public Joueur (int x,int y,Environnement env) {

        super(5,2,5,3,x,y,env);
        // this.isJumpong=  false;
        //ArrayList<Inventaire> inventaire = new ArrayList<Inventaire>();

    }


    public void seDeplpaceDroite () {

<<<<<<< HEAD
        int xDest = this.xProperty().getValue() + getVitesse();
        if (this.terrain.tuileTraversable(xDest + 27, getY())) {
=======
        int xDest = this.xProperty().getValue()+getVitesse();

        if (this.terrain.tuileTraversable(xDest+27, getY())) {
            Acteur.limitationMapX();
>>>>>>> origin/merge
            this.setX(xDest);
            this.verifGravite();
        }
    }

    public void seDeplpaceGacuhe () {

<<<<<<< HEAD
            int yDest = this.xProperty().getValue() - getVitesse();
        if (this.terrain.tuileTraversable(getX() + 5, getY())) {
=======
        int yDest = this.xProperty().getValue()-getVitesse();
        if (this.terrain.tuileTraversable(getX()+5, getY())) {
            Acteur.limitationMapX();

>>>>>>> origin/merge
            this.setX(yDest);
            this.verifGravite();
        }
            System.out.println(xProperty().getValue());
        }



    @Override
    public void seDeplpaceHaut() {

           this.yProperty().setValue(this.yProperty().getValue() - getSaut() * 2);
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
}
