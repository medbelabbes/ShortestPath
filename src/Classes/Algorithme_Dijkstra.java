/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static Windows.Principal_Window.graphe_panel;
import static Windows.Principal_Window.R_repaint;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Algorithme_Dijkstra {

    private Graphe graphe;
    private int min_nbr_sommet;
    private Sommet auxi = null;//in sommet auxilliare
    private int auxDistance; // une distance auxilliaire
    private int minDistance;
    private Sommet sommet[];
    private int nbr_sommet;
    private int SommetActuel;
    private int sommetFin;

    public Algorithme_Dijkstra(Graphe graphe, int nbr_sommet, int actuel, int sommetFin) {
        this.graphe = graphe;
        this.nbr_sommet = nbr_sommet;
        this.sommet = new Sommet[nbr_sommet];
        this.SommetActuel = actuel;
        this.sommetFin = sommetFin;

    }

    public int getDistance() {
        return sommet[sommetFin].getDistance();
    }

    public void dijkstra() {
        for (int i = 0; i < nbr_sommet; i++) // Nous créons la taille maximale de vecteur de noeud qui a le numéro de noeud peint
        {
            sommet[i] = new Sommet();
        }

        if (SommetActuel != sommetFin) {
            graphe_panel.paint(graphe_panel.getGraphics());
            R_repaint(nbr_sommet, graphe);
            Paint.cliquer_à_gauche_sommet(graphe_panel.getGraphics(), graphe.getCordX(SommetActuel), graphe.getCordY(SommetActuel), null, Color.GREEN); // Peindre le sommet avec la couleure verte

            sommet[SommetActuel].setVisité(true);
            sommet[SommetActuel].setNombre(SommetActuel);

            do {
                minDistance = 0;
                auxDistance = 2000000000; // Nous adaptons ce chiffre et les nœuds  prétendument jamais être plus
                sommet[SommetActuel].setEtiquete(true);
                for (int j = 0; j < nbr_sommet; j++) {
                    if (graphe.getMatrice_adjacence(j, SommetActuel) == 1) {
                        minDistance = sommet[SommetActuel].getDistance() + graphe.getMatrice_Coefficients(j, SommetActuel);
                        if (minDistance <= sommet[j].getDistance() && sommet[j].isVisité() == true && sommet[j].isEtiquete() == false) {
                            sommet[j].setDistance(minDistance);
                            sommet[j].setVisité(true);
                            sommet[j].setNombre(j);
                            sommet[j].setPrédécesseur(sommet[SommetActuel]);
                        } else if (sommet[j].isVisité() == false) {
                            sommet[j].setDistance(minDistance);
                            sommet[j].setVisité(true);
                            sommet[j].setNombre(j);
                            sommet[j].setPrédécesseur(sommet[SommetActuel]);
                        }
                    }
                }
                for (int i = 0; i < nbr_sommet; i++) { // 
                    if (sommet[i].isVisité() == true && sommet[i].isEtiquete() == false) {
                        if (sommet[i].getDistance() <= auxDistance) {
                            SommetActuel = sommet[i].getNombre();
                            auxDistance = sommet[i].getDistance();
                        }
                    }
                }
                min_nbr_sommet++;
            } while (min_nbr_sommet < nbr_sommet + 1);
            auxi = sommet[sommetFin];
            if (auxi.getPrédécesseur() == null) {
                JOptionPane.showMessageDialog(null, "Ne pourrait pas atteindre le sommet " + sommetFin);
            }
            while (auxi.getPrédécesseur() != null) {
                Paint.Paint_Path(graphe_panel.getGraphics(), graphe.getCordX(auxi.getNombre()), graphe.getCordY(auxi.getNombre()), graphe.getCordX(auxi.getPrédécesseur().getNombre()), graphe.getCordY(auxi.getPrédécesseur().getNombre()), Color.GREEN);
                Paint.cliquer_à_gauche_sommet(graphe_panel.getGraphics(), graphe.getCordX(auxi.getNombre()), graphe.getCordY(auxi.getNombre()), null, Color.GREEN);
                auxi = auxi.getPrédécesseur();
            }
            Paint.cliquer_à_gauche_sommet(graphe_panel.getGraphics(), graphe.getCordX(sommetFin), graphe.getCordY(sommetFin), null, Color.GREEN);
        } else {
            Paint.cliquer_à_gauche_sommet(graphe_panel.getGraphics(), graphe.getCordX(sommetFin), graphe.getCordY(sommetFin), null, Color.GREEN);
        }
    }
}
