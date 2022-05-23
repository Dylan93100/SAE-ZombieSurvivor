package com.example.zombiesurvivor.controleur;

import com.example.zombiesurvivor.modele.*;
import com.example.zombiesurvivor.vue.JoueurVue;
import com.example.zombiesurvivor.vue.TerrainVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {

    private Terrain terrain;
    private Environnement env;
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.terrain = new Terrain();
        env = new Environnement();

        TerrainVue terrainVue = new TerrainVue(env.getTerrain(), paneTerrain);
        JoueurVue joueurVue = new JoueurVue(paneRacine,env.getPersonage());
        initAnimation();

        // demarre l'animation
        gameLoop.play();
        Border1.addEventFilter(KeyEvent.KEY_PRESSED, (key)-> {
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

        Border1.addEventFilter(KeyEvent.KEY_RELEASED, (key)-> {
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
                            env.getPersonage().limitationMapX();
                            env.getPersonage().seDeplaceDroite();
                            env.getPersonage().verifGravite();
                            System.out.println(env);
                            if(tic%15==0) {
                                animation = !animation;
                                JoueurVue.apparanceDroitecourt(animation);
                            }
                        }
                        if(left==true) {
                            JoueurVue.apparanceGauche();
                            env.getPersonage().limitationMapX();
                            env.getPersonage().seDeplaceGacuhe();
                            env.getPersonage().verifGravite();

                            if(tic%15==0) {
                                animation = !animation;
                                System.out.println(animation);
                                JoueurVue.apparanceGauchecourt(animation);
                            }
                        }
                        if(up==true) {
                            env.getPersonage().verifGravite();
                            délaiSaut+=.25;
                            env.getPersonage().yProperty().setValue(verivSaut(Yhere, délaiSaut));
                            env.getPersonage().verifGravite();
                        }
                        else {
                            Yhere=env.getPersonage().yProperty().getValue();
                            délaiSaut=.0;
                        }
                        if(env.getPersonage().isGravite()) {
                            env.getPersonage().setyValue(-3);
                            env.getPersonage().verifGravite();
                        }
                        System.out.println(env);
                        delay++;
                        temps++;
                })
        );
        this.gameLoop.getKeyFrames().add(kf);
    }
}
