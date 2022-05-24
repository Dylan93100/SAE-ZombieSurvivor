package com.example.zombiesurvivor.vue;

import com.example.zombiesurvivor.Main;
import com.example.zombiesurvivor.modele.Joueur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class InventaireVue {



    private static Pane paneRacine;
    private static ImageView HUDV;

    public  InventaireVue(Pane paneRacine) {
        this.paneRacine = paneRacine;
        this.afficherInventaitr();
    }

    private void afficherInventaitr () {

        Image HUD = new Image(Main.class.getResource("images/inventaire.png").toString());

        HUDV = new ImageView(HUD);

        HUDV.translateXProperty(940);
        HUDV.translateYProperty();
        paneRacine.getChildren().add(HUDV);
    }
}
