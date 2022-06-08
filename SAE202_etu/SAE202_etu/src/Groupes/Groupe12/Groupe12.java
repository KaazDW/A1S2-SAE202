/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Groupes.Groupe12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.graphstream.algorithm.coloring.WelshPowell;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import packMesClassesEtInterfaces.SAE202_Algos;
import static packMesClassesEtInterfaces.SAE202_Algos.charger_graphe;
import static packMesClassesEtInterfaces.SAE202_Algos.compte_nb_conflits;
import packMesClassesEtInterfaces.SAE202_Interface;

/**
 *
 *
 */
public class Groupe12 implements SAE202_Interface {

    /**
     * Calcule les colorations pour un graph donné.
     *
     * @param prefixeFichier
     * @param nbFichiers
     * @param millisecondes
     */
    @Override
    public void challenge(String prefixeFichier, Integer nbFichiers, Long millisecondes) {
        int nbGraph = 0;
        long temps = 0;
        long temps2 = 0;
        temps = System.currentTimeMillis();
        for (int i = 0; i < nbFichiers; i++) {
            if (temps2 < millisecondes) {
                System.out.println("grpah nb :" + i);
                Graph g = charger_graphe(prefixeFichier + i + ".txt");
                algoWelshPowell(g);

                descente(g, (int) (millisecondes / 1));

//        long temps = 0;
//        while (temps < millisecondes - 10000) {
//            temps = System.currentTimeMillis();
//              //apelle colorier
//            temps = System.currentTimeMillis() - temps;
//        }
//                   long temps=System.currentTimeMillis();
//                temps=System.currentTimeMillis()-temps;
//        temps=Math.toIntExact(temps)
//            System.out.println("graphe numero : " + nbGraph + " nombre de conflit : " + calculeNombreConflits(g));
                nbGraph++;
            }
            temps2 = System.currentTimeMillis() - temps;
            System.out.println(temps2);
        }
        temps2 = System.currentTimeMillis() - temps;
        System.out.println(" temps d'execution : " + (double) temps2 / 1000 + "s");
    }

    /**
     * Fonction calculant 10 graph à partir de 10 fichiers de vols
     * @param prefixeFichier
     * @param nbFichiers
     * @param millisecondes
     */
    @Override
    public void modelisation(String prefixeFichier, Integer nbFichiers, Long millisecondes) {

    }
    /**
     * Fonction de coloration aléatoire du graph passé en paramètre
     * @param g
     * @param millisecondes
     * @return le nombre de conflits
     */
    public int colorierAlea(Graph g, int millisecondes) {
        int kmax = g.getAttribute("nb_couleurs_max");
        for (Node sommet : g.getEachNode()) {
            sommet.setAttribute("couleur", (int) (Math.random() * kmax));
        }
        return SAE202_Algos.compte_nb_conflits(g, "couleur");
    }

    /**
     * Fonction appliquant la méthode Descente consistant à parcourir tous les voisins d'une coloration et à prendre la meilleurs, et de recommencer l'opération jusqu'a tomber dans un minimul locale
     * @param g
     * @param millisecondes
     * @return le nombre de conflits
     */
    public int descente(Graph g, int millisecondes) {

        long temps = System.currentTimeMillis();
        long temps2 = 0;
        int cout = 0;
        int coutMinimum = -1;
        int stock = 0;
        int numArrete = -1;
        boolean rentrer = true;
        int indiceCoutMin = 0;
        int valeurCouleur = 0;
        int kmax = g.getAttribute("nb_couleurs_max");
        while (coutMinimum < SAE202_Algos.compte_nb_conflits(g, "couleur") && temps2 < millisecondes && rentrer == true) {
            rentrer = false;
            for (Edge arrete : g.getEachEdge()) {
                if (arrete.getNode0().getAttribute("couleur") == arrete.getNode1().getAttribute("couleur")) {
                    cout = SAE202_Algos.compte_nb_conflits(g, "couleur");
                    for (int i = 0; i < kmax; i++) {
                        valeurCouleur = arrete.getNode0().getAttribute("couleur");
                        arrete.getNode0().setAttribute("couleur", i);
                        if (SAE202_Algos.compte_nb_conflits(g, "couleur") < cout) {
                            indiceCoutMin = i;
                            stock = arrete.getIndex();
                            numArrete = 0;
                            coutMinimum = SAE202_Algos.compte_nb_conflits(g, "couleur");
                            rentrer = true;
                        }
                        arrete.getNode0().setAttribute("couleur", valeurCouleur);
                    }
                    for (int i = 0; i < kmax; i++) {
                        valeurCouleur = arrete.getNode1().getAttribute("couleur");
                        arrete.getNode1().setAttribute("couleur", i);
                        if (SAE202_Algos.compte_nb_conflits(g, "couleur") < cout) {
                            indiceCoutMin = i;
                            stock = arrete.getIndex();
                            numArrete = 1;
                            coutMinimum = SAE202_Algos.compte_nb_conflits(g, "couleur");
                            rentrer = true;
                        }
                        arrete.getNode1().setAttribute("couleur", valeurCouleur);
                    }
                }
                temps2 = System.currentTimeMillis() - temps;
            }
            if (numArrete == 0) {
                g.getEdge(stock).getNode0().setAttribute("couleur", indiceCoutMin);
            } else if (numArrete == 1) {
                g.getEdge(stock).getNode1().setAttribute("couleur", indiceCoutMin);

            }
        }

        System.out.println("nb conflits minimun : " + coutMinimum);
        System.out.println("nb conflits descente : " + SAE202_Algos.compte_nb_conflits(g, "couleur"));
        return SAE202_Algos.compte_nb_conflits(g, "couleur");
    }

    public int algoWelshPowell(Graph g) {
        int kmax = g.getAttribute("nb_couleurs_max");
        WelshPowell wp = new WelshPowell("couleur");
        wp.init(g);
        wp.compute();
        for (Node sommet : g.getEachNode()) {
            if ((int) sommet.getAttribute("couleur") > kmax - 1) {
                sommet.setAttribute("couleur", (int) Math.random() * kmax);
            }
        }
        System.out.println("nb conflits Powell : " + SAE202_Algos.compte_nb_conflits(g, "couleur"));
        return SAE202_Algos.compte_nb_conflits(g, "couleur");
    }

    public int recuitSimulé(Graph g, int millisecondes) {
        algoWelshPowell(g);
        int puissance = 1;
        double risque = Math.pow(0.5, puissance) * 30;
        for (int i = 0; i < 50; i++) {

            puissance++;
        }

        return SAE202_Algos.compte_nb_conflits(g, "couleur");
    }
}
