package com.example.zombiesurvivor.modele;

import com.example.zombiesurvivor.vue.InventaireVue;
import com.example.zombiesurvivor.vue.JoueurVue;

public class Joueur extends Acteur {
    private Inventaire inventaire;
    Pierre pierre;
    Bois bois;
    Viande vache;
    Epee p = new Epee();
    Botte b = new Botte();
    Lance l = new Lance();
    private boolean aLeppe;
    private boolean aLance;

    private boolean epeeActve;

    private boolean lanceActve;

    private Boolean juste = false;
    private int tic = 0;
    private boolean animation = false;
    private boolean up = false, down = false, left = false, right = false;
    private double Yhere;
    private double délaiSaut;
    private int verifSaut;


    public Joueur (int x, int y, Environnement env) {

        super(500, 2, 5, 3, x, y, env);
        inventaire = new Inventaire();
        pierre = new Pierre();
        vache = new Viande(0,0,null);
        bois = new Bois();
        System.out.println(inventaire);
    }

    public void agir () {
        if (!up) verifGravite();
        if (right == true) {

            JoueurVue.apparanceDroite();
            limitationMapX();
            seDeplpaceDroite();

            if (tic % 15 == 0) {
                animation = !animation;
                JoueurVue.apparanceDroitecourt(animation);
            }
        }

        if (left == true) {
            JoueurVue.apparanceGauche();
            limitationMapX();
            seDeplpaceGacuhe();


            if (tic % 15 == 0) {
                animation = !animation;
                System.out.println(animation);
                JoueurVue.apparanceGauchecourt(animation);
            }
        }

        if (up == true) {

            verifSaut = (int) verivSaut(Yhere, délaiSaut);
            délaiSaut += .25;
            yProperty().setValue(verivSaut(Yhere, délaiSaut));
            if (verifSaut == YProperty.getValue()) {
                up = false;
                verifGravite();
            }
        }
//                }
        else {
            Yhere = yProperty().getValue();
            délaiSaut = .0;

        }

        if (isGravite()) {
            setyValue(-3);
            verifGravite();
        }


    }

    public double verivSaut (double Yhere, double délaiSaut) {

        return (délaiSaut * délaiSaut) - 20 * délaiSaut + Yhere;

    }


    public void seDeplpaceDroite () {

        int xDest = this.xProperty().getValue() + getVitesse();
        if (this.terrain.tuileTraversable(xDest + 27, getY() + 20)) {
            this.setX(xDest);
        }
    }

    public void seDeplpaceGacuhe () {

        int yDest = this.xProperty().getValue() - getVitesse();
        if (this.terrain.tuileTraversable(getX() + 5, getY())) {
            this.setX(yDest);
        }
        System.out.println(xProperty().getValue());
    }


    //@Override
   // public void seDeplpaceHaut () {

        //this.yProperty().setValue(this.yProperty().getValue() - getSaut() * 2);
   // }

    public void droite () {
        this.right = true;
        this.left = false;
    }

    public void gauche () {
        this.left = true;
        this.right = false;
    }

    public void haut () {

        if (!isGravite())
            this.up = true;
    }

    public void neVaPLusADroite () {
        this.right = false;

    }

    public void neVaPLusAGauche () {
        this.left = false;
    }

    public void neVaPLusEnHaut () {

        this.up = false;
    }

    public void epeeDanSaMain () {

        this.lanceActve = false;
        this.epeeActve = true;
        if(epeeActve==true && aLeppe==true){
            System.out.println("HAHAHAHA");
        }
    }
    public void lanceDanSaMain () {
        this.epeeActve = false;
        this.lanceActve = true;
        if(lanceActve==true && aLance==true){
            System.out.println("HOHOHOHOHO  ");
        }
    }
    public void craftEpee (InventaireVue inventaireVue) {

        System.out.println(inventaire.toString());
        if (!inventaire.getEquipInv().contains(p)) {
            if (pierre.getQuantité() >= 40 && bois.getQuantité() >= 60) {
                inventaire.getEquipInv().add(p);
                pierre.setQuantité(pierre.getQuantité() - 40);
                bois.setQuantité(bois.getQuantité() - 60);
                inventaireVue.aquesitionDeLepee();
                        aLeppe = true;
            }
        }
    }

    public void craftBotte (InventaireVue inventaireVue) {

        if (!inventaire.getEquipInv().contains(b)) {
            if (vache.getQuantité() >= 10 && bois.getQuantité() >= 40) {
                inventaire.getEquipInv().add(b);
                bois.setQuantité(bois.getQuantité() - 40);
                vache.setQuantité(vache.getQuantité() - 10);
                inventaireVue.aquesitionDeBotte();
                setVitesse(getVitesse()+2);

            }
        }
    }

    public void craftLancepierre (InventaireVue inventaireVue) {

        if (!inventaire.getEquipInv().contains(l)) {
            if (bois.getQuantité() >= 30 && pierre.getQuantité() >= 50 && vache.getQuantité() >= 30) {
                inventaire.getEquipInv().add(l);
                bois.setQuantité(bois.getQuantité() - 30);
                pierre.setQuantité(pierre.getQuantité() - 50);
                vache.setQuantité(vache.getQuantité() - 30);
                inventaireVue.aquesitionDeLance();
                aLance = true;
            }
        }
    }
//    public void craftclee (){
//        Clee c;
//        if(inventaire.getBois==10 && inventaire.getPierre==10 && inventaire.getCuire==10){
//            inventaire.add(c);
//        }


    public Pierre getPierre () {
        return pierre;
    }

    public Bois getBois () {
        return bois;
    }

    public Viande getViande () {
        return vache;
    }

    public Inventaire getInventaire () {
        return inventaire;
    }

    public boolean isaLeppe () {
        return aLeppe;
    }

    public Boolean getJuste () {
        return juste;
    }
}
//
//
//


