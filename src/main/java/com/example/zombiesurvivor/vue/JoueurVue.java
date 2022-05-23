package com.example.zombiesurvivor.vue;

import com.example.zombiesurvivor.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import com.example.zombiesurvivor.modele.Joueur;


public class JoueurVue {

    private static Pane paneRacine;
    private Joueur joueur;
    private static ImageView backD;
    private static ImageView backG;
    private static ImageView backDr;
    private static ImageView backGr;


    public  JoueurVue(Pane paneRacine, Joueur joueur) {
        this.paneRacine = paneRacine;
        this.joueur = joueur;
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

//	public static void limitationMapX() {
//		if(Joueur.xProperty().getValue()>935) {
//			Joueur.setxValue(3);
//			System.out.println("Vous avez atteint la limte de la map");
//		}
//		if(Joueur.xProperty().getValue()<-5) {
//			Joueur.setxValue(-3);
//			System.out.println("Vous avez atteint la limte de la map");
//		}
//	}
//

}
