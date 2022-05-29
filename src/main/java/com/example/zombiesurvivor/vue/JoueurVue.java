package com.example.zombiesurvivor.vue;

import com.example.zombiesurvivor.Main;
import com.example.zombiesurvivor.modele.Environnement;
import com.example.zombiesurvivor.modele.Joueur;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class JoueurVue {

    private static Pane paneRacine;
    private final Environnement env;
    private Joueur joueur;
    private static ImageView backD;
    private static ImageView backG;
    private static ImageView backDr;
    private static ImageView backGr;

    private Label labelVie = new Label("5");



    public  JoueurVue(Pane paneRacine, Joueur joueur, Environnement env) {
        this.paneRacine = paneRacine;
        this.joueur = joueur;
        this.env = env;
        this.afficherJoueur();
    }


    public void afficherJoueur() {


        Image joueurDroite = new Image(Main.class.getResource("images/iamePersoDroite.png").toString());
        Image joueurGauche = new Image(Main.class.getResource("images/imagePersoGauche.png").toString());
        Image joueurDroitecourt = new Image(Main.class.getResource("images/doitecourt.png").toString());
        Image joueurGauchecourt = new Image(Main.class.getResource("images/Gauchecourt.png").toString());


        backGr = new ImageView(joueurGauchecourt);
        backGr.translateXProperty().bind(joueur.xProperty());
        backGr.translateYProperty().bind(joueur.yProperty());
        paneRacine.getChildren().add(backGr);

        backGr.setVisible(false);

        backDr = new ImageView(joueurDroitecourt);
        backDr.translateXProperty().bind(joueur.xProperty());
        backDr.translateYProperty().bind(joueur.yProperty());
        paneRacine.getChildren().add(backDr);

        backDr.setVisible(false);


        backG = new ImageView(joueurGauche);
        backG.translateXProperty().bind(joueur.xProperty());
        backG.translateYProperty().bind(joueur.yProperty());
        paneRacine.getChildren().add(backG);
        System.out.println(backG);

        backG.setVisible(false);

        backD = new ImageView(joueurDroite);
        backD.translateXProperty().bind(joueur.xProperty());
        backD.translateYProperty().bind(joueur.yProperty());
        paneRacine.getChildren().add(backD);

        labelVie.setTranslateX(50);
        labelVie.setTranslateY(20);
        labelVie.setTextFill(Color.WHITE);
        paneRacine.getChildren().add(labelVie);

    }
    public static void apparanceDroite() {
        backG.setVisible(false);
        backD.setVisible(true);
    }
    public static void apparanceGauche() {
        backD.setVisible(false);
        backG.setVisible(true);
    }

    public static void apparanceDroitecourt(boolean upVer) {
        backGr.setVisible(false);
        backG.setVisible(false);

        if(upVer) {
            backD.setVisible(false);
            backDr.setVisible(true);
        }
        else {
            backDr.setVisible(false);
            backD.setVisible(true);
        }
    }

    public static void apparanceGauchecourt(boolean upVer) {
        backD.setVisible(false);
        backDr.setVisible(false);

        if(upVer) {
            backG.setVisible(false);
            backGr.setVisible(true);
        }
        else {
            backGr.setVisible(false);
            backG.setVisible(true);
        }
    }

    public  void imageMort() {

        paneRacine.getChildren().remove(backD);
        paneRacine.getChildren().remove(backDr);
        paneRacine.getChildren().remove(backG);
        paneRacine.getChildren().remove(backGr);

    }

public void affichageVie(){

    labelVie.textProperty().bind(env.getPersonage().vieProperty().asString());

}

}
