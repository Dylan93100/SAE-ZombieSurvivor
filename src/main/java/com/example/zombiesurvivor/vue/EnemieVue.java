package com.example.zombiesurvivor.vue;

import com.example.zombiesurvivor.Main;
import com.example.zombiesurvivor.modele.EnemieNv1;
import com.example.zombiesurvivor.modele.Environnement;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class EnemieVue {
    private static Pane paneRacine;
    private Environnement env;
    private static ImageView enemieNv1DroiteV;
    private static ImageView enemieNv1GaucheV;

    public  EnemieVue(Pane paneRacine, Environnement env) {
        this.paneRacine = paneRacine;
        this.env = env;
        this.afficherEnnemieNv1();
    }
    
    public void afficherEnnemieNv1(){
        Image enemieNv1Droite = new Image(Main.class.getResource("images/iamePersoDroite.png").toString());
        Image enemieNv1Gauche = new Image(Main.class.getResource("images/imagePersoGauche.png").toString());

        enemieNv1GaucheV = new ImageView(enemieNv1Gauche);
        enemieNv1GaucheV.translateXProperty().bind(env.getEnnemie().xProperty());
        enemieNv1GaucheV.translateYProperty().bind(env.getEnnemie().yProperty());
        paneRacine.getChildren().add(enemieNv1GaucheV);

        enemieNv1GaucheV.setVisible(false);

        enemieNv1DroiteV = new ImageView(enemieNv1Droite);
        enemieNv1DroiteV.translateXProperty().bind(env.getEnnemie().xProperty());
        enemieNv1DroiteV.translateYProperty().bind(env.getEnnemie().yProperty());
        paneRacine.getChildren().add(enemieNv1DroiteV);

    }
    
    public static void apparanceDroite() {
        enemieNv1GaucheV.setVisible(false);
        enemieNv1DroiteV.setVisible(true);
    }
    public static void apparanceGauche() {
        enemieNv1DroiteV.setVisible(false);
        enemieNv1GaucheV.setVisible(true);
    }
    

}
