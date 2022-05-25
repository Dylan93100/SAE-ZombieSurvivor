package com.example.zombiesurvivor.vue;

import com.example.zombiesurvivor.Main;
import com.example.zombiesurvivor.modele.Joueur;
import com.example.zombiesurvivor.modele.Viande;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PnjVue {

    private static Pane paneRacine;
    private Viande vache;
    private static ImageView vacheV;

    public PnjVue(Pane paneRacine, Viande vache) {
        this.paneRacine = paneRacine;
        this.vache = vache;
        this.afficherPnj();
    }

    private void afficherPnj() {

        Image vachev = new Image(Main.class.getResource("images/vache.png").toString());


        vacheV = new ImageView(vachev);
        vacheV.translateXProperty().bind(vache.XPropertyProperty());
        vacheV.translateYProperty().bind(vache.YPropertyProperty());
        paneRacine.getChildren().add(vacheV);

    }
}
