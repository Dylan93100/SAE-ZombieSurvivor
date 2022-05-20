package com.example.zombiesurvivor.modele;

import javafx.beans.property.IntegerProperty;

public class Terrain {

    public IntegerProperty[] getCodesTuiles;

    int [] codesTuiles = {
            1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,
            1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,
            1267,29112,29112,29112,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,
            1267,1267,29120,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,
            1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,29112,29112,29112,29112,29112,1267,1267,1267,1267,1267,1267,
            1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,29120,29120,29120,1267,1267,1267,1267,1267,1267,1267,
            1267,1267,1267,1267,1267,1267,1267,1267,1267,29112,29112,29112,29112,29112,1267,1267,1267,1267,1267,1267,1267,29120,1267,1267,1267,1267,1267,1267,1267,1267,
            1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,29120,29120,29120,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,
            1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,29120,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,
            1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,29112,29112,
            1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,1267,29112,29112,29120,29120,
            29112,29112,29112,1267,1267,1267,1267,29112,29112,29112,29112,29112,29112,29112,29112,29112,29112,29112,29112,29112,29112,29112,29112,29112,29112,29112,29120,29120,29120,29120,
            29120,29120,29120,29112,1267,1267,29112,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,
            29120,29120,29120,29120,29112,29112,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,
            29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,
            29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,
            29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,
            29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,
            29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,
            29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120,29120
    };

    public int[] getCodesTuiles() {
        return codesTuiles;
    }

    public int CodesTuiles(int i) {
        return codesTuiles[i];
    }

    public int tuile(int x, int y) {
        return codesTuiles[x/32+y/32*30];
    }

    public boolean tuileSol(int x, int y) {
        return this.tuile(x,y) != 1267;
    }

    public boolean tuileTraversable(int x, int y) {
        return this.tuile(x,y) == 1267;
    }



//	public void getX() {
//		return codesTuiles[i][j];
//	}
//
//	public void getY() {
//		return codesTuiles [0][j];
//	}


}
