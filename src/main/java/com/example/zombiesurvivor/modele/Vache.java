package com.example.zombiesurvivor.modele;

public class Vache extends Acteur {

	public Vache (int x ,int y,Environnement env) {
		super(5,3,0,0,x,y,env);

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
	public void agir() {

	}
}
