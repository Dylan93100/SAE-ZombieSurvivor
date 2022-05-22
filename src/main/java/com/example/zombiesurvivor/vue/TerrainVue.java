package com.example.zombiesurvivor.vue;

import com.example.zombiesurvivor.Main;
import com.example.zombiesurvivor.modele.Environnement;
import com.example.zombiesurvivor.modele.Terrain;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class TerrainVue {

    private Terrain terrain;
    private TilePane paneTerrain;

private Environnement env;

    public TerrainVue(Terrain terrain, TilePane paneTerrain) {
        super();
        this.terrain = terrain;
        this.paneTerrain = paneTerrain;
        this.afficherTerrain();
        this.env = env;
    }

    public void afficherTerrain() {
        int[] codesTuiles =  terrain.getCodesTuiles();

        Image ciel = new Image(Main.class.getResource("images/cielfonce.png").toString());
        Image tileset = new Image(Main.class.getResource("images/terrainFinal.png").toString());

        for (int i=0 ; i<codesTuiles.length;i++) {
            if (codesTuiles[i]==1267) {
                paneTerrain.getChildren().add(new ImageView(ciel));
            }
            else if(codesTuiles[i]==29120) {
                ImageView terre = new ImageView(tileset);
                terre.setViewport(new Rectangle2D(6,20, 32, 32));
                paneTerrain.getChildren().add(terre);
            }

            else {
                ImageView pierre = new ImageView(tileset);
                pierre.setViewport(new Rectangle2D(3, 3, 32, 32));
                paneTerrain.getChildren().add((pierre));
            }
        }





    }


}
