/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Groupes.Groupe12;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import static packMesClassesEtInterfaces.SAE202_Algos.charger_graphe;
import packMesClassesEtInterfaces.SAE202_Interface;

/**
 *
 *
 */
public class Groupe12 implements SAE202_Interface {

    private Graph graph;

    public Graph getGraph() {
        return graph;
    }

    @Override
    public void challenge(String prefixeFichier, Integer nbFichiers, Long millisecondes) {
        colorierAlea(graph, Math.toIntExact(millisecondes));
        long temps = 0;
        while (temps < millisecondes - 10000) {
            temps = System.currentTimeMillis();
              //apelle colorier
            temps = System.currentTimeMillis() - temps;
        }
//                   long temps=System.currentTimeMillis();
//                temps=System.currentTimeMillis()-temps;
//        temps=Math.toIntExact(temps)
    }

    public void chargerGraphe(String nom_fichier) {
        graph = charger_graphe(nom_fichier);
    }

    @Override
    public void modelisation(String prefixeFichier, Integer nbFichiers, Long millisecondes) {

    }

    public void afficheGraph(Graph g) {
        int cpt = 1;
        for (Node sommet : g.getEachNode()) {
            System.out.println("sommet :" + cpt + " couleur : " + sommet.getAttribute("couleur"));
            cpt++;
        }
    }

    public Graph colorierAlea(Graph g, int millisecondes) {

        int kmax = 0;
        kmax = g.getAttribute("nb_couleurs_max");
        for (Node sommet : g.getEachNode()) {
            sommet.setAttribute("couleur", (int) (Math.random() * kmax));
        }

        return g;
    }
    
    public void descente (Graph g){
        int kmax = 0;
        kmax = g.getAttribute("nb_couleurs_max");
        for (Node sommet : g.getEachNode()) {
            for (int i = 0; i < kmax; i++) {
                
            }
        }
    }
}
