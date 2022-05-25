package com.example.zombiesurvivor.vue;

import com.example.zombiesurvivor.Main;
import com.example.zombiesurvivor.modele.Viande;
import com.example.zombiesurvivor.modele.enemieNv1;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class PnjVue {

    private static Pane paneRacine;
    private Viande vacher;
    private static ImageView vacheV;

    private enemieNv1 enemieNv1;
    private ImageView enemieV;

    public PnjVue(Pane paneRacine, Viande vacher,enemieNv1 enemieNv1) {
        this.paneRacine = paneRacine;
        this.vacher = vacher;
        this.enemieNv1 = enemieNv1;
        this.afficherPnj();
    }

    private void afficherPnj() {

        Image vache = new Image(Main.class.getResource("images/arbre.png").toString());
        Image ennemie = new Image(Main.class.getResource("images/lance.png").toString());

        vacheV = new ImageView(vache);
        vacheV.translateXProperty().bind(vacher.XPropertyProperty());
        vacheV.translateYProperty().bind(vacher.YPropertyProperty());
        paneRacine.getChildren().add(vacheV);

        enemieV = new ImageView(ennemie);
        enemieV.translateXProperty().bind(enemieNv1.xProperty());
        enemieV.translateYProperty().bind(enemieNv1.yProperty());
        paneRacine.getChildren().add(enemieV);

    }
}
