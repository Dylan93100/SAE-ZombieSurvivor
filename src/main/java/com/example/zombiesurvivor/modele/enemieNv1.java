package com.example.zombiesurvivor.modele;

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
public void attaque(){
    for(Acteur m : getEnv().getListperso()){
        if(m instanceof Joueur){
            if((this.getX()-5<= m.getX() && m.getX()<=this.getX()+5))
                getEnv().getEnnemie().enleveVie(getEnv().getPersonage());
        }
        if(getEnv().getPersonage().estMort()){
            getEnv().getListperso().remove(m);
        }
    }

    }
    public void BFS(){

    }
}

