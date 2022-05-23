package com.example.zombiesurvivor.modele;

public class EnnemieNv1 extends Acteur {

    public EnnemieNv1(int x, int y, Environnement env) {
        super(5, 5, 1, 5, x, y, env);
        System.out.println(getEnv());
        System.out.println(getTerrain());
    }

    @Override
    public void seDeplaceDroite() {
        if (Math.random() * 4 > 2) {
            int xDest = this.xProperty().getValue() + getVitesse();
            if (this.terrain.tuileTraversable(getX() + 27, getY())) {
                this.setX(xDest);
            }
        }
    }

    @Override
    public void seDeplaceGacuhe() {
        if (Math.random() * 4 > 2) {
            int yDest = this.xProperty().getValue() - getVitesse();
            if (this.terrain.tuileTraversable(getX() + 5, getY())) {
                this.setX(yDest);
            }
        }
    }

    @Override
    public void seDeplaceHaut() {
    }

    public void attaque() {
        for (int i = getEnv().getListperso().size() - 1; i == 0; i--) {
            if (getEnv().getListperso().get(i) instanceof Joueur) {
                if ((this.getX() - 5 <= getEnv().getListperso().get(i).getX() && getEnv().getListperso().get(i).getX() <= this.getX() + 5))
                    this.enleveVie(getEnv().getListperso().get(i));
            }
            if (getEnv().getPersonage().estMort()) {
                getEnv().getListperso().remove(getEnv().getListperso().get(i));
            }
        }
    }

    public void BFS() {
    }
}

