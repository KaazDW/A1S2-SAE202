/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Groupes.Groupe12;

import java.util.ArrayList;
import java.util.HashSet;
import org.graphstream.algorithm.coloring.WelshPowell;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import packMesClassesEtInterfaces.SAE202_Algos;
import static packMesClassesEtInterfaces.SAE202_Algos.charger_graphe;
import packMesClassesEtInterfaces.SAE202_Interface;

/**
 *
 *
 */
public class Groupe12 implements SAE202_Interface {

    @Override
    public void challenge(String prefixeFichier, Integer nbFichiers, Long millisecondes) {
        int nbGraph = 0;
        long temps = 0;
        temps = System.currentTimeMillis();
        for (int i = 0; i < nbFichiers; i++) {
            System.out.println("grpah nb :" + i);
            Graph g = charger_graphe(prefixeFichier + i + ".txt");
            colorierAlea(g, 1000);
            descente(g, 10000);

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
        temps = System.currentTimeMillis() - temps;
        System.out.println(" temps d'execution : " + (double) temps / 1000 + "s");
    }

    @Override
    public void modelisation(String prefixeFichier, Integer nbFichiers, Long millisecondes) {

    }

    public void afficheGraph(Graph g) {
        int cpt = 1;
        for (Node sommet : g.getEachNode()) {
            System.out.println("couleur : " + (int) sommet.getAttribute("couleur"));
            cpt++;

        }
    }

    public int colorierAlea(Graph g, int millisecondes) {
        int kmax = g.getAttribute("nb_couleurs_max");
        for (Node sommet : g.getEachNode()) {
            sommet.setAttribute("couleur", (int) (Math.random() * kmax));
        }
        System.out.println(SAE202_Algos.compte_nb_conflits(g, "couleur"));
        return SAE202_Algos.compte_nb_conflits(g, "couleur");
    }

    public int descente(Graph g, int millisecondes) {
        int cout = 0;
        int coutMinimum=0;
        int stock = 0;
        int numArrete = -1;
        int indiceCoutMin = 0;
        int valeurCouleur = 0;
        int kmax = g.getAttribute("nb_couleurs_max");
       while (coutMinimum < SAE202_Algos.compte_nb_conflits(g, "couleur")) {
                     if (numArrete == 0) {
            g.getEdge(stock).getNode0().setAttribute("couleur", indiceCoutMin);
        } else if(numArrete==1){
            g.getEdge(stock).getNode1().setAttribute("couleur", indiceCoutMin);
        
        }
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
                        }
                        arrete.getNode1().setAttribute("couleur", valeurCouleur);
                    }
                }
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
