/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Moh Pixou
 */
public class Sommet {

    private int nombre;
    private boolean visité;
    private boolean etiquete;
    private int distance;
    private Sommet prédécesseur;

    public Sommet() {
        this.nombre = -1;
        this.visité = false;
        this.etiquete = false;
        this.prédécesseur = null;
        this.distance = 0;
    }

    public int getNombre() {
        return nombre;
    }

    public boolean isVisité() {
        return visité;
    }

    public boolean isEtiquete() {
        return etiquete;
    }

    public int getDistance() {
        return distance;
    }

    public Sommet getPrédécesseur() {
        return prédécesseur;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public void setVisité(boolean v) {
        this.visité = v;
    }

    public void setEtiquete(boolean etiquete) {
        this.etiquete = etiquete;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setPrédécesseur(Sommet prédécesseur) {
        this.prédécesseur = prédécesseur;
    }

}
