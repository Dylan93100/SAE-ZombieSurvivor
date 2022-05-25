package com.example.zombiesurvivor.modele;

import com.example.zombiesurvivor.vue.EnemieVue;
import com.example.zombiesurvivor.vue.JoueurVue;

public class EnemieNv1 extends Acteur {


    public EnemieNv1(int x , int y, Environnement env) {
        super(5, 5, 1, 5, x, y,env);
        System.out.println(getEnv());
        System.out.println(getTerrain());
    }

    @Override
    public void seDeplpaceDroite() {
        if (Math.random() * 4 > 2) {
            int xDest = this.xProperty().getValue() + getVitesse();
            if (this.terrain.tuileTraversable(getXValue() + 27, getYValue())) {
                this.setX(xDest);
            }
        }
    }

    @Override
    public void seDeplpaceGacuhe() {
        if (Math.random() * 4 > 2) {
            int yDest = this.xProperty().getValue() - getVitesse();
            if (this.terrain.tuileTraversable(getXValue() + 5, getYValue())) {
                this.setX(yDest);
            }
        }
    }



    @Override
    public void seDeplpaceHaut() {
    }

    @Override
    public void agir () {
        if(10% 2 == 0) {
            seDeplpaceDroite();
            EnemieVue.apparanceDroite();
        }
        else
        seDeplpaceGacuhe();
        EnemieVue.apparanceGauche();
    }

    public void attaque(JoueurVue jou){


        for (int i = getEnv().getActeurs().size()-1; i==0; i--){
        if(getEnv().getActeurs().get(i) instanceof Joueur){
            if((this.getXValue()-5<= getEnv().getActeurs().get(i).getXValue() && getEnv().getActeurs().get(i).getXValue()<=this.getXValue()+5))
                this.enleveVie(getEnv().getActeurs().get(i));
            System.out.println(getEnv());
        }
        if(getEnv().getPersonage().estMort()){
            getEnv().getActeurs().remove(getEnv().getActeurs().get(i));
            jou.imageMort();

            }
        }

    }
    public void BFS(){

    }
}

