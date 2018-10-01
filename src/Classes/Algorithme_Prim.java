/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static Windows.Principal_Window.R_repaint;
import static Windows.Principal_Window.entrer_sommet_source;
import static Windows.Principal_Window.graphe_panel;
import java.awt.Color;

public class Algorithme_Prim {

    private int Distance;
    private int min_poid_aréte;
    private int fin;
    private boolean est_sommet = false;
    private boolean taille_augmente;
    private int sommet_ciblé;
    private int pointeur_sommet;
    private int taille;
    private int max_poid_aréte;
    private Graphe graphe;
    private int nbr_sommet;
    private int sommet_origine;

    public Algorithme_Prim(Graphe graphe, int nbr_sommet, int max_poid_aréte) {
        this.Distance = 0;
        this.min_poid_aréte = 0;
        this.fin = 0;
        this.est_sommet = false;
        this.taille_augmente = false;
        this.sommet_ciblé = 0;
        this.pointeur_sommet = 0;
        this.taille = 1;
        this.max_poid_aréte = max_poid_aréte;
        this.graphe = graphe;
        this.nbr_sommet = nbr_sommet;
    }

    public int getDistance() {
        return Distance;
    }

    public void prim() {
        this.sommet_origine = entrer_sommet_source("Entrer un sommet Origine..", "sommet origine n'existe pas", nbr_sommet);
        graphe_panel.paint(graphe_panel.getGraphics());
        R_repaint(nbr_sommet, graphe);
        graphe.Créer_EnGraphe(nbr_sommet);
        graphe.setEnGraphe(0, sommet_origine);
        //algorithme de Prim ---->>
        do {
            this.min_poid_aréte = this.max_poid_aréte;
            this.fin = 2;
            for (int j = 0; j < taille; j++) {
                for (int k = 0; k < nbr_sommet; k++) {
                    if (graphe.getMatrice_adjacence(k, graphe.getEnGraphe(j)) == 1) {
                        for (int h = 0; h < taille; h++) {
                            if (graphe.getEnGraphe(h) == k) {
                                this.est_sommet = true;
                                break;
                            }
                        }
                        if (est_sommet == false) {
                            if (graphe.getMatrice_Coefficients(k, graphe.getEnGraphe(j)) <= min_poid_aréte && graphe.getMatrice_Coefficients(k, graphe.getEnGraphe(j)) > 0) {
                                min_poid_aréte = graphe.getMatrice_Coefficients(k, graphe.getEnGraphe(j));
                                this.sommet_ciblé = k;
                                this.taille_augmente = true;
                                this.pointeur_sommet = graphe.getEnGraphe(j);
                                this.fin = 1;
                            }
                        }
                        this.est_sommet = false;
                    }
                }
            }//fin  for (int j = 0; j < taille; j++)              
            if (taille_augmente == true) {
                Paint.Paint_Path(graphe_panel.getGraphics(), graphe.getCordX(pointeur_sommet), graphe.getCordY(pointeur_sommet), graphe.getCordX(sommet_ciblé), graphe.getCordY(sommet_ciblé), Color.red);
                Paint.cliquer_à_gauche_sommet(graphe_panel.getGraphics(), graphe.getCordX(pointeur_sommet), graphe.getCordY(pointeur_sommet), null, Color.red);
                Paint.cliquer_à_gauche_sommet(graphe_panel.getGraphics(), graphe.getCordX(sommet_ciblé), graphe.getCordY(sommet_ciblé), null, Color.red);
                graphe.setEnGraphe(taille, sommet_ciblé);
                this.taille++;
                this.taille_augmente = false;
                this.Distance += this.min_poid_aréte;
            }
        } while (fin < 2);
    }

}
