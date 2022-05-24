package com.example.zombiesurvivor.vue;

import com.example.zombiesurvivor.Main;
import com.example.zombiesurvivor.modele.Joueur;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class InventaireVue {



    private static Pane paneRacine;
    private static ImageView HUDV;
    private static ImageView BoisV;
    private static ImageView PierreV;
    private static ImageView VacheV;
    private static ImageView HacheV;
    private static ImageView PiocheV;
    private static ImageView EpeeV;
    private static ImageView BotteV;
    private static ImageView LanceV;
    private static Label labelbois;

    public  InventaireVue(Pane paneRacine) {
        this.paneRacine = paneRacine;
        this.afficherInventaire();
    }

    private void afficherInventaire () {

        Image HUD = new Image(Main.class.getResource("images/inventaire.png").toString());
        Image bois = new Image(Main.class.getResource("images/bois.png").toString());
        Image pierre = new Image(Main.class.getResource("images/pierre.png").toString());
        Image vache = new Image(Main.class.getResource("images/food.png").toString());
        Image hache = new Image(Main.class.getResource("images/Hache.png").toString());
        Image pioche = new Image(Main.class.getResource("images/Pioche.png").toString());
        Image epee = new Image(Main.class.getResource("images/Epee.png").toString());
        Image botte = new Image(Main.class.getResource("images/bottes.png").toString());
        Image lance = new Image(Main.class.getResource("images/Lance.png").toString());


        HUDV = new ImageView(HUD);
        BoisV = new ImageView(bois);
        PierreV = new ImageView(pierre);
        VacheV = new ImageView(vache);
        HacheV = new ImageView(hache);
        PiocheV =new ImageView(pioche);
        EpeeV = new ImageView(epee);
        BotteV = new ImageView(botte);
        LanceV =new ImageView(lance);

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

        HacheV.setTranslateX(362);
        HacheV.setTranslateY(470);
        paneRacine.getChildren().add(HacheV);

        PiocheV.setTranslateX(397);
        PiocheV.setTranslateY(470);
        paneRacine.getChildren().add(PiocheV);

        EpeeV.setTranslateX(432);
        EpeeV.setTranslateY(470);
        paneRacine.getChildren().add(EpeeV);

        EpeeV.setVisible(false);

        BotteV.setTranslateX(468);
        BotteV.setTranslateY(472);
        paneRacine.getChildren().add(BotteV);

        BotteV.setVisible(false);


        LanceV.setTranslateX(503);
        LanceV.setTranslateY(472);
        paneRacine.getChildren().add(LanceV);

        LanceV.setVisible(false);

    }

public void aquesitionDeLepee(){
        EpeeV.setVisible(true);
}
    public void aquesitionDeBotte(){
        BotteV.setVisible(true);
    }
    public void aquesitionDeLance(){
        LanceV.setVisible(true);
    }

}
