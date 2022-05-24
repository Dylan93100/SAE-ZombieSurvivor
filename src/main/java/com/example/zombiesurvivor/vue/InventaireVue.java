package com.example.zombiesurvivor.vue;

import com.example.zombiesurvivor.Main;
import com.example.zombiesurvivor.modele.Joueur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class InventaireVue {



    private static Pane paneRacine;
    private static ImageView HUDV;
    private static ImageView BoisV;
    private static ImageView PierreV;
    private static ImageView VacheV;


    public  InventaireVue(Pane paneRacine) {
        this.paneRacine = paneRacine;
        this.afficherInventaitr();
    }

    private void afficherInventaitr () {

        Image HUD = new Image(Main.class.getResource("images/inventaire.png").toString());
        Image bois = new Image(Main.class.getResource("images/bois.png").toString());
        Image pierre = new Image(Main.class.getResource("images/pierre.png").toString());
        Image vache = new Image(Main.class.getResource("images/food.png").toString());



        HUDV = new ImageView(HUD);
        BoisV = new ImageView(bois);
        PierreV = new ImageView(pierre);
        VacheV = new ImageView(vache);

        HUDV.setTranslateX(250);
        HUDV.setTranslateY(470);
        paneRacine.getChildren().add(HUDV);

        BoisV.setTranslateX(288);
        BoisV.setTranslateY(473);
        paneRacine.getChildren().add(BoisV);

        PierreV.setTranslateX(250);
        PierreV.setTranslateY(470);
        paneRacine.getChildren().add(PierreV);

        VacheV.setTranslateX(323);
        VacheV.setTranslateY(472);
        paneRacine.getChildren().add(VacheV);

    }
}
