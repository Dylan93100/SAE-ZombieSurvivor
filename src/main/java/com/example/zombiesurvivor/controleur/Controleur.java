package com.example.zombiesurvivor.controleur;

import com.example.zombiesurvivor.modele.Environnement;
import com.example.zombiesurvivor.modele.Terrain;
import com.example.zombiesurvivor.vue.InventaireVue;
import com.example.zombiesurvivor.vue.JoueurVue;
import com.example.zombiesurvivor.vue.PnjVue;
import com.example.zombiesurvivor.vue.TerrainVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class Controleur implements Initializable {

    private Terrain terrain;

    private Environnement env;

    private int delay=0;

    private int delaysaut =5;

    private Timeline gameLoop;

    private boolean animation = false ;

    private int tic = 0;

    private int temps;

    private JoueurVue joueurVue;

    private InventaireVue inventaireVue;

    @FXML
    private TilePane paneTerrain;

    @FXML
    private VBox VboxRacine;

    @FXML
    private Pane paneRacine;

    @FXML
    private Label ho;

    @FXML
    private Label boisBesoins;

    @FXML
    private Label qantitePierre;

    @FXML
    private Label viandeBesoins;

    @FXML
    private Label pierreBesoins;

    @FXML
    private Label qantiteBois;

    @FXML
    private Label qantiteViand;


    @FXML
    private BorderPane Border1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.terrain = new Terrain();
        env = new Environnement();

        //jou = new Joueur(350,160,env);
        //enn = new enemieNv1(350,160,env)

        TerrainVue terrainVue = new TerrainVue(env.getTerrain(), paneTerrain);

        joueurVue = new JoueurVue(paneRacine,env.getPersonage());

         inventaireVue = new InventaireVue(paneRacine,env,VboxRacine);

        PnjVue pnjvue = new PnjVue(paneRacine,env.getVache(),env.getEnnemie());

        initAnimation();

        // demarre l'animation

        gameLoop.play();


        Border1.addEventFilter(KeyEvent.KEY_PRESSED, (key)->
        {

            if(key.getCode() == KeyCode.D) {
                this.env.getPersonage().droite();
            }

            if(key.getCode() == KeyCode.Q) {
                this.env.getPersonage().gauche();
            }

            if(key.getCode() == KeyCode.Z) {
                this.env.getPersonage().haut();

            }
        });

        Border1.addEventFilter(KeyEvent.KEY_RELEASED, (key)->
        {

            if(key.getCode() == KeyCode.D) {
                this.env.getPersonage().neVaPLusADroite();
            }

            if(key.getCode() == KeyCode.Q) {
                this.env.getPersonage().neVaPLusAGauche();
            }

            if(key.getCode() == KeyCode.Z) {
                this.env.getPersonage().neVaPLusEnHaut();
            }

        });

//        paneRacine.setOnMouseEntered(new EventHandler() {
//            @Override
//            public void handle(Event arg0) {
//                Image cursor = new Image("images/doitecourt.png");
//                paneRacine.getScene().setCursor(new ImageCursor(cursor));
//            }
//        });



    }

    @FXML
    void craftBotte(ActionEvent event) {
        env.getPersonage().getViande().augmente();
        env.getPersonage().craftBotte(inventaireVue);
    }

    @FXML
    void craftEpee(ActionEvent event) {
        env.getPersonage().getBois().augmente();
        env.getPersonage().craftEpee(inventaireVue);
    }

    @FXML
    void craftLancepierre(ActionEvent event) {
        env.getPersonage().getPierre().augmente();
        env.getPersonage().craftLancepierre(inventaireVue);

    }


    void initAnimation() {
        this.gameLoop = new Timeline();
        this.temps=0;
        this.gameLoop.setCycleCount(Timeline.INDEFINITE);

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.013),
                (ev -> {
                    tic++;

                    inventaireVue.MAJ(env);
                    System.out.println(env.getPersonage().getVie());
                    this.env.getVache().agir();
                    this.env.getPersonage().agir();
                    this.env.getEnnemie().agir(joueurVue);

//
//                    System.out.println(env.getPersonage().getVie());
//                    env.getEnnemie().attaque(joueurVue);
//                    env.getEnnemie().enleveVie(env.getPersonage());
//                    System.out.println(env.getPersonage().getVie());
//                    System.out.println(env.getPersonage().getEnv());
                    temps++;
                })
        );
        this.gameLoop.getKeyFrames().add(kf);


    }


}
