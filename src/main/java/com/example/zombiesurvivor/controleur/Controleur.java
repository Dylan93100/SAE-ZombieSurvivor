package com.example.zombiesurvivor.controleur;
import java.net.URL;

import com.example.zombiesurvivor.modele.Acteur;
import com.example.zombiesurvivor.modele.Joueur;
import com.example.zombiesurvivor.modele.Terrain;
import com.example.zombiesurvivor.vue.JoueurVue;
import com.example.zombiesurvivor.vue.TerrainVue;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import com.example.zombiesurvivor.modele.Acteur;
import com.example.zombiesurvivor.modele.Joueur;
import com.example.zombiesurvivor.modele.Terrain;
import com.example.zombiesurvivor.vue.JoueurVue;
import com.example.zombiesurvivor.vue.TerrainVue;


public class Controleur implements Initializable {

    private Terrain terrain;

    private Joueur joueur1;

    private int delay=0;

    private int delaysaut =5;

    private Timeline gameLoop;

    private double Yhere;

    private boolean animation = false ;

    private int tic = 0;

    private int temps;

    private boolean up = false, down = false,left = false, right = false;

    private double délaiSaut;

    @FXML
    private TilePane paneTerrain;

    @FXML
    private Pane paneRacine;

    @FXML
    private BorderPane Border1;


    //@FXML
    //private Pane PaneDeplacement;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.terrain = new Terrain();
        TerrainVue terrainVue = new TerrainVue(terrain, paneTerrain);

        joueur1 = new Joueur(terrain) ;

        JoueurVue joueurVue = new JoueurVue(paneRacine,joueur1);

        initAnimation();

        // demarre l'animation

        gameLoop.play();

        Border1.addEventFilter(KeyEvent.KEY_PRESSED, (key)->
        {

            if(key.getCode() == KeyCode.RIGHT) {
                right = true;
            }

            if(key.getCode() == KeyCode.LEFT) {
                left=true;
            }

            if(key.getCode() == KeyCode.UP) {
                up=true;

            }
        });

        Border1.addEventFilter(KeyEvent.KEY_RELEASED, (key)->
        {

            if(key.getCode() == KeyCode.RIGHT) {
                right = false;
            }

            if(key.getCode() == KeyCode.LEFT) {
                left=false;
            }

            if(key.getCode() == KeyCode.UP) {
                up = false;
            }

        });



    }

    public double verivSaut(double Yhere,double délaiSaut ) {

        return(délaiSaut*délaiSaut)-20*délaiSaut+Yhere;

    }


    void initAnimation() {
        this.gameLoop = new Timeline();
        this.temps=0;
        this.gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.01),
                (ev -> {
                    tic++;
                    if(right == true) {

                        JoueurVue.apparanceDroite();
                        Acteur.limitationMapX();
                        joueur1.seDeplpaceDroite();
                        joueur1.verifGravite();

                        if(tic%15==0) {
                            animation = !animation;
                            JoueurVue.apparanceDroitecourt(animation);
                        }
                    }

                    if(left==true) {
                        JoueurVue.apparanceGauche();
                        Acteur.limitationMapX();
                        joueur1.seDeplpaceGacuhe();
                        joueur1.verifGravite();

                        if(tic%15==0) {
                            animation = !animation;
                            System.out.println(animation);
                            JoueurVue.apparanceGauchecourt(animation);
                        }
                    }

                    if(up==true) {

                        //joueur1.seDeplpaceHaut();
                        joueur1.verifGravite();
                        délaiSaut+=.25;
                        joueur1.yProperty().setValue(verivSaut(Yhere, délaiSaut));
                        joueur1.verifGravite();
                    }

                    else {

                        Yhere=joueur1.yProperty().getValue();
                        délaiSaut=.0;

                    }

                    if(joueur1.isGravite()) {
                        joueur1.setyValue(-3);
                        joueur1.verifGravite();
                    }
                    Acteur.colis();
                    Acteur.limitationMapX();
                    delay++;
                    temps++;
                })
        );
        this.gameLoop.getKeyFrames().add(kf);


    }


}
