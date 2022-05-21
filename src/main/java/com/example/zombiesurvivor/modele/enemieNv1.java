package com.example.zombiesurvivor.modele;

public class enemieNv1 extends Acteur {

    public enemieNv1(Terrain terrain, Environnement env) {
        super(5, 5, 4, 5, 300, 100, terrain, env);
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
    for (int i = 0 ;i<getEnv().getListperso().size();i++){
    if(getEnv().getPersonage().getX()<5) {
        this.enleveVie(getEnv().getPersonage());
        }
    }
}

}

