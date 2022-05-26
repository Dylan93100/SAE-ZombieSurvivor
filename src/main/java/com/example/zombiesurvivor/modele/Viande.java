package com.example.zombiesurvivor.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Viande extends Ressource {

    private IntegerProperty XProperty;
    private IntegerProperty YProperty;
    private Environnement env;
    private int x, y;
    boolean gravite;


    public Viande(int x, int y, Environnement env) {
        super(2);
        this.XProperty = new SimpleIntegerProperty(x);
        this.YProperty = new SimpleIntegerProperty(y);
        this.env = env;
        x = x;
        y = y;
    }

    public boolean isGravite() {
        return gravite;
    }

    public void verifGravite() {
        if (!env.getTerrain().tuileSol(this.getXProperty(), this.getYProperty() + 32)) {
            this.gravite = true;
        } else {
            this.gravite = false;
        }
    }

    public int getXProperty() {
        return XProperty.get();
    }

    public void setyValue(int n) {
        this.YPropertyProperty().setValue(this.YPropertyProperty().getValue() - n);
    }

    public IntegerProperty XPropertyProperty() {
        return XProperty;
    }

    public int getYProperty() {
        return YProperty.get();
    }

    public IntegerProperty YPropertyProperty() {
        return YProperty;
    }

    public void setXProperty(int XProperty) {
        this.XProperty.set(XProperty);
    }

    public void setYProperty(int YProperty) {
        this.YProperty.set(YProperty);
    }

    public void setX(int newX) {
        XProperty.setValue(newX);
    }


    public void agir () {
        verifGravite();
        allerAdroite();
        allerAgauche();

        if (isGravite()) {
            setyValue(-3);
            verifGravite();
        }
    }

    public void allerAdroite() {
        if (Math.random() * 4 > 2) {
            int xDest = this.XPropertyProperty().getValue() + 2;
            if (this.env.getTerrain().tuileTraversable(getXProperty() + 27, getYProperty())) {
                this.setX(xDest);
            }
        }
    }

    public void allerAgauche() {
        if (Math.random() * 5 > 2) {
            int yDest = this.XPropertyProperty().getValue() - 2;
            if (this.env.getTerrain().tuileTraversable(getXProperty() + 5, getYProperty())) {
                this.setX(yDest);
            }
        }
    }
}


//	@Override
//	public String toString() {
//		return "Viande [" + super.getQuantité() ;
//	}

