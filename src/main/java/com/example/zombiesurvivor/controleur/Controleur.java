package com.example.zombiesurvivor.controleur;

import com.example.zombiesurvivor.modele.*;
import com.example.zombiesurvivor.vue.JoueurVue;
import com.example.zombiesurvivor.vue.TerrainVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class Controleur implements Initializable {

    private Terrain terrain;

    private Environnement env;

    //private Acteur jou;

    //private Acteur enn;

    private int delay=0;

    private int delaysaut =5;

    private Timeline gameLoop;



    private boolean animation = false ;

    private int tic = 0;

    private int temps;

    private JoueurVue joueurVue;


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
        env = new Environnement();

        //jou = new Joueur(350,160,env);
        //enn = new enemieNv1(350,160,env)

        TerrainVue terrainVue = new TerrainVue(env.getTerrain(), paneTerrain);

        JoueurVue joueurVue = new JoueurVue(paneRacine,env.getPersonage());

        initAnimation();

        // demarre l'animation

        gameLoop.play();


        Border1.addEventFilter(KeyEvent.KEY_PRESSED, (key)->
        {

            if(key.getCode() == KeyCode.RIGHT) {
                this.env.getPersonage().droite();
            }

            if(key.getCode() == KeyCode.LEFT) {
                this.env.getPersonage().gauche();
            }

            if(key.getCode() == KeyCode.UP) {
                this.env.getPersonage().haut();

            }
        });

        Border1.addEventFilter(KeyEvent.KEY_RELEASED, (key)->
        {

            if(key.getCode() == KeyCode.RIGHT) {
                this.env.getPersonage().neVaPLusADroite();
            }

            if(key.getCode() == KeyCode.LEFT) {
                this.env.getPersonage().neVaPLusAGauche();
            }

            if(key.getCode() == KeyCode.UP) {
                this.env.getPersonage().neVaPLusEnHaut();
            }

        });

        paneRacine.setOnMouseEntered(new EventHandler() {
            @Override
            public void handle(Event arg0) {
                Image image = new Image("images/doitecourt.png");
                paneRacine.getScene().setCursor(new ImageCursor(image));
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

                    this.env.getPersonage().agir();


//
//                    System.out.println(env.getPersonage().getVie());
//                    env.getEnnemie().attaque(joueurVue);
//                    env.getEnnemie().enleveVie(env.getPersonage());
//                    System.out.println(env.getPersonage().getVie());
//                    System.out.println(env.getPersonage().getEnv());
                    delay++;
                    temps++;
                })
        );
        this.gameLoop.getKeyFrames().add(kf);


    }


}
