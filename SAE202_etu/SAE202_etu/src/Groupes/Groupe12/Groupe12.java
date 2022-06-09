/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Groupes.Groupe12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.graphstream.algorithm.coloring.WelshPowell;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import packMesClassesEtInterfaces.SAE202_Algos;
import static packMesClassesEtInterfaces.SAE202_Algos.charger_graphe;
import static packMesClassesEtInterfaces.SAE202_Algos.compte_nb_conflits;
import packMesClassesEtInterfaces.SAE202_Interface;
import java.io.*;

/**
 *
 *
 */
public class Groupe12 implements SAE202_Interface {

    /**
     * Calcule les colorations pour un graph donné.
     * @param prefixeFichier Préfixe du nom du fichier (exemple : "prefixeFichierY.csv" avec Y = numéro du fichier en question);
     * @param nbFichiers Le nombre de fichiers a traiter (les indices des fichiers débutent à 0.
     * @param millisecondes Durée maximum prévu pour l'execution de la fonction
     */
    @Override
    public void challenge(String prefixeFichier, Integer nbFichiers, Long millisecondes) {
        ArrayList<Integer> listNbColor = new ArrayList<Integer>();
        int nbGraph = 0;
        long temps = 0;
        long temps2 = 0;
        File ligne = new File("Resultats/coloration-groupe12.csv");
        temps = System.currentTimeMillis();
        for (int i = 0; i < nbFichiers; i++) {
            if (temps2 < millisecondes) {
                Graph g = charger_graphe(prefixeFichier + i + ".txt");
                algoWelshPowell(g);
//                recuitSimulé(g, (int) (millisecondes / 1));
                listNbColor.add(colorier(g, (int) (millisecondes / 1)));
                nbGraph++;
                SAE202_Algos.sauver_coloration(g, prefixeFichier, 12);

            }
            temps2 = System.currentTimeMillis() - temps;
        }
        ligne.getParentFile().mkdirs();
        try {
            try ( FileWriter fileWriter = new FileWriter(ligne)) {

                for (int i = 0; i < nbFichiers; i++) {
                    fileWriter.append(prefixeFichier + "" + i + ".txt");
                    fileWriter.append(';');
                    fileWriter.append("" + listNbColor.get(i));
                    fileWriter.append('\n');
                }
            }
        } catch (Exception ee) {

        }
        temps2 = System.currentTimeMillis() - temps;
        System.out.println(" temps d'execution : " + (double) temps2 / 1000 + "s");
    }

    /**
     * Fonction calculant 10 graph à partir de 10 fichiers de vols
     * @param prefixeFichier Préfixe du nom du fichier (exemple : "prefixeFichierY.csv" avec Y = numéro du fichier en question);
     * @param nbFichiers Le nombre de fichiers a traiter (les indices des fichiers débutent à 0.
     * @param millisecondes Durée maximum prévu pour l'execution de la fonction
     * @throws java.io.IOException
     */
    @Override
    public void modelisation(String prefixeFichier, Integer nbFichiers, Long millisecondes) {


    }

    /**
     * Fonction de coloration aléatoire du graph passé en paramètre
<<<<<<< Updated upstream
     * @param g Graph à traiter
     * @param millisecondes Durée maximum prévu pour l'execution de la fonction
=======
     *
     * @param gGraph a traité
     * @param millisecondes
>>>>>>> Stashed changes
     * @return le nombre de conflits générés
     */
    public int colorierAlea(Graph g, int millisecondes) {
        int kmax = g.getAttribute("nb_couleurs_max");
        for (Node sommet : g.getEachNode()) {
            sommet.setAttribute("couleur", (int) (Math.random() * kmax));
        }
        return SAE202_Algos.compte_nb_conflits(g, "couleur");
    }

    /**
     * Fonction appliquant la méthode Descente consistant à parcourir tous les
     * voisins d'une coloration et à prendre la meilleurs, et de recommencer
<<<<<<< Updated upstream
     * l'opération jusqu'a tomber dans un minimul locale.
     * @param g Graph à traiter
     * @param millisecondes Durée maximum prévu pour l'execution de la fonction
=======
     * l'opération jusqu'a tomber dans un minimul locale
     *
     * @param gGraph a traité
     * @param millisecondes
>>>>>>> Stashed changes
     * @return le nombre de conflits générés
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
//        System.out.println("nb conflits minimun : " + coutMinimum);
//        System.out.println("nb conflits descente : " + SAE202_Algos.compte_nb_conflits(g, "couleur"));
        return SAE202_Algos.compte_nb_conflits(g, "couleur");
    }

    /**
     * Cette fonction est destiné à implémenter l'algorithme de coloration de
     * graph Welsh-Powell
<<<<<<< Updated upstream
     * @param g Graph à traiter
=======
     *
     * @param g Graph a traité
>>>>>>> Stashed changes
     * @return le nombre de conflits générés
     */
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
        return SAE202_Algos.compte_nb_conflits(g, "couleur");
    }

    /**
<<<<<<< Updated upstream
     *  Fonction destiné à implémenter l'algorithme itératif Recuit Simulé
     * @param g Graph à traiter
     * @param millisecondes Durée maximum prévu pour l'execution de la fonction
=======
     * Fonction destiné à implémenter l'algorithme itératif Recuit Simulé
     *
     * @param g Graph a traité
     * @param millisecondes
>>>>>>> Stashed changes
     * @return le nombre de conflits générés
     */
    public int recuitSimulé(Graph g, int millisecondes) {
        long temps = System.currentTimeMillis();
        long temps2 = 0;
        int cout = 0;
        int coutMinimum = -1;
        int coutMinimumEleve = -1;
        int stock = 0;
        int stockEleve = 0;
        int numArrete = -1;
        int numArreteEleve = -1;
        boolean rentrer = true;
        int indiceCoutMin = 0;
        int indiceCoutMinEleve = 0;
        int valeurCouleur = 0;
        int kmax = g.getAttribute("nb_couleurs_max");
        int puissance = 1;
        while (temps2 < millisecondes && rentrer == true) {
            rentrer = false;
            double risque = Math.pow(0.5, puissance) * 30;
            //boucle pour incrementer puissance tout les 10
            for (int j = 0; j < 10; j++) {
                //parcours des arrete
                for (Edge arrete : g.getEachEdge()) {
                    //Verification des conflits
                    if (arrete.getNode0().getAttribute("couleur") == arrete.getNode1().getAttribute("couleur")) {
                        cout = SAE202_Algos.compte_nb_conflits(g, "couleur");
                        //boucle qui parcours les valeurs de nos couleurs possible pour le node0
                        for (int i = 0; i < kmax; i++) {
                            valeurCouleur = arrete.getNode0().getAttribute("couleur");
                            arrete.getNode0().setAttribute("couleur", i);
                            //condition qui verifie que le coup du graphe voisin soit plus petit
                            if (SAE202_Algos.compte_nb_conflits(g, "couleur") < cout) {
                                indiceCoutMin = i;
                                stock = arrete.getIndex();
                                numArrete = 0;
                                coutMinimum = SAE202_Algos.compte_nb_conflits(g, "couleur");
                                rentrer = true;
                            } else {
                                if (Math.random() < Math.exp((cout - SAE202_Algos.compte_nb_conflits(g, "couleur")) / risque)) {
                                    indiceCoutMinEleve = i;
                                    stockEleve = arrete.getIndex();
                                    numArreteEleve = 0;
                                    coutMinimumEleve = SAE202_Algos.compte_nb_conflits(g, "couleur");
                                }
                            }
                            arrete.getNode0().setAttribute("couleur", valeurCouleur);
                        }
                        //boucle qui parcours les valeurs de nos couleurs possible pour le node1
                        for (int i = 0; i < kmax; i++) {
                            valeurCouleur = arrete.getNode1().getAttribute("couleur");
                            arrete.getNode1().setAttribute("couleur", i);
                            //condition qui verifie que le coup du graphe voisin soit plus petit
                            if (SAE202_Algos.compte_nb_conflits(g, "couleur") < cout) {
                                indiceCoutMin = i;
                                stock = arrete.getIndex();
                                numArrete = 1;
                                coutMinimum = SAE202_Algos.compte_nb_conflits(g, "couleur");
                                rentrer = true;
                            } else {
                                if (Math.random() < Math.exp((cout - SAE202_Algos.compte_nb_conflits(g, "couleur")) / risque)) {
                                    indiceCoutMinEleve = i;
                                    stockEleve = arrete.getIndex();
                                    numArreteEleve = 1;
                                    coutMinimumEleve = SAE202_Algos.compte_nb_conflits(g, "couleur");
                                }
                            }
                            arrete.getNode1().setAttribute("couleur", valeurCouleur);
                        }
                    }
                }
            }
            puissance++;
            temps2 = System.currentTimeMillis() - temps;
        }
        System.out.println("appres algo recruit : " + SAE202_Algos.compte_nb_conflits(g, "couleur"));
        return SAE202_Algos.compte_nb_conflits(g, "couleur");
    }
<<<<<<< Updated upstream
    
    /**
     * Fonction colorier vissant à appliquer la méthode Descente au Graph en question, avec la durée maximum défini en paramètre.
     * @param g Graph à traiter
     * @param millisecondes Durée maximum prévu pour l'execution de la fonction
     * @return la fonction Descente
     */
    public int colorier(Graph g, int millisecondes){
        return descente(g,millisecondes);
=======

    public int colorier(Graph g, int millisecondes) {
        return descente(g, millisecondes);
>>>>>>> Stashed changes
    }
    
   

}
