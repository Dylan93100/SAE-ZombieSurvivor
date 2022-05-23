package com.example.zombiesurvivor.modele;

import com.example.zombiesurvivor.vue.JoueurVue;

public class enemieNv1 extends Acteur {


    public enemieNv1(int x ,int y,Environnement env) {
        super(5, 5, 1, 5, x, y,env);
        System.out.println(getEnv());
        System.out.println(getTerrain());
    }

    @Override
    public void seDeplpaceDroite() {
        if (Math.random() * 4 > 2) {
            int xDest = this.xProperty().getValue() + getVitesse();
            if (this.terrain.tuileTraversable(getX() + 27, getY())) {
                this.setX(xDest);
            }
        }
    }

    @Override
    public void seDeplpaceGacuhe() {
        if (Math.random() * 4 > 2) {
            int yDest = this.xProperty().getValue() - getVitesse();
            if (this.terrain.tuileTraversable(getX() + 5, getY())) {
                this.setX(yDest);
            }
        }
    }

    @Override
    public void seDeplpaceHaut() {

    }

    @Override
    public void agir () {

    }

    public void attaque(JoueurVue jou){


        for (int i = getEnv().getListperso().size()-1;i==0;i--){
        if(getEnv().getListperso().get(i) instanceof Joueur){
            if((this.getX()-5<= getEnv().getListperso().get(i).getX() && getEnv().getListperso().get(i).getX()<=this.getX()+5))
                this.enleveVie(getEnv().getListperso().get(i));
            System.out.println(getEnv());
        }
        if(getEnv().getPersonage().estMort()){
            getEnv().getListperso().remove(getEnv().getListperso().get(i));
            jou.imageMort();

        }
    }

    }
    public void BFS(){

    }
}

