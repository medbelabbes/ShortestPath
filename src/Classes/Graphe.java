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
public class Graphe {

    private int Matrice_Coefficients[][] = new int[500][500];
    private int Matrice_adjacence[][] = new int[500][500];
    private int cordX[] = new int[500];
    private int cordY[] = new int[500];
    private int nombre[] = new int[500];
    private int enGraphe[];

    public Graphe() {

    }

    public int getMatrice_Coefficients(int i, int j) {
        return Matrice_Coefficients[i][j];
    }

    public int getMatrice_adjacence(int i, int j) {
        return Matrice_adjacence[i][j];
    }

    public int getCordX(int i) {
        return cordX[i];
    }

    public int getCordY(int i) {
        return cordY[i];
    }

    public int getNombre(int i) {
        return nombre[i];
    }

    public int getEnGraphe(int i) {
        return enGraphe[i];
    }

    public void setMatrice_Coefficients(int i, int j, int Matrice_Coefficients) {
        this.Matrice_Coefficients[i][j] = Matrice_Coefficients;
    }

    public void setMatrice_adjacence(int i, int j, int Matrice_adjacence) {
        this.Matrice_adjacence[i][j] = Matrice_adjacence;
    }

    public void setCordX(int i, int cordX) {
        this.cordX[i] = cordX;
    }

    public void setCordY(int i, int cordY) {
        this.cordY[i] = cordY;
    }

    public void setNombre(int i, int nombre) {
        this.nombre[i] = nombre;
    }

    public void setEnGraphe(int i, int enGraphe) {
        this.enGraphe[i] = enGraphe;
    }

    public void Créer_EnGraphe(int i) {
        enGraphe = new int[i];
    }

}
