package com.example.zombiesurvivor.modele;


import com.example.zombiesurvivor.vue.JoueurVue;
import javafx.scene.image.ImageView;

public class Joueur extends Acteur{
    //private boolean isJumpong = false;

    //ArrayList<Inventaire> inventaire = new ArrayList<Inventaire>();

    public Joueur (Terrain terrain) {

        super(0,2,5,3,terrain);
        // this.isJumpong=  false;
        //ArrayList<Inventaire> inventaire = new ArrayList<Inventaire>();

    }


    public void seDeplpaceDroite () {

        int xDest = this.xProperty().getValue()+getVitesse();

        if (this.terrain.tuileTraversable(xDest+27, getY())) {
            Acteur.limitationMapX();
            this.setX(xDest);
            this.verifGravite();
        }
    }

    public void seDeplpaceGacuhe () {

        int yDest = this.xProperty().getValue()-getVitesse();
        if (this.terrain.tuileTraversable(getX()+5, getY())) {
            Acteur.limitationMapX();

            this.setX(yDest);
            this.verifGravite();
        }

        System.out.println(xProperty().getValue());

    }


    @Override
    public void seDeplpaceHaut() {
        this.yProperty().setValue(this.yProperty().getValue()-getSaut()*2);

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
