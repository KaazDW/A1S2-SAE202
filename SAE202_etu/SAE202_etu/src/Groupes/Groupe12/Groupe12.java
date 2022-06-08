/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Groupes.Groupe12;

import java.awt.Color;
import java.util.Iterator;
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

    private Graph graph;

    public Graph getGraph() {
        return graph;
    }

    @Override
    public void challenge(String prefixeFichier, Integer nbFichiers, Long millisecondes) {
        int graphe = 0;
        for (int i = 0; i < nbFichiers; i++) {
            Graph g = charger_graphe(prefixeFichier + i + ".txt");
            Wheshp(g);
//        long temps = 0;
//        while (temps < millisecondes - 10000) {
//            temps = System.currentTimeMillis();
//              //apelle colorier
//            temps = System.currentTimeMillis() - temps;
//        }
//                   long temps=System.currentTimeMillis();
//                temps=System.currentTimeMillis()-temps;
//        temps=Math.toIntExact(temps)
            afficheGraph(g);
            System.out.println("graphe numero : " + graphe + " nombre de conflit : " + calculeNombreConflits(g));
            graphe++;
        }
    }

    @Override
    public void modelisation(String prefixeFichier, Integer nbFichiers, Long millisecondes) {

    }

    public void afficheGraph(Graph g) {
        int cpt = 1;
        for (Node sommet : g.getEachNode()) {
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

    public void descente(Graph g) {
        int kmax = 0;
        kmax = g.getAttribute("nb_couleurs_max");
        for (Node sommet : g.getEachNode()) {
            for (int i = 0; i < kmax; i++) {

            }
        }
    }

    public int calculeNombreConflits(Graph g) {
        return SAE202_Algos.compte_nb_conflits(g, "color");
    }

    public int Wheshp(Graph g) {
         		WelshPowell wp = new WelshPowell("color");
 		wp.init(g);
 		wp.compute();
        for (Node sommet : g.getEachNode()) {
             System.out.println("couleur " + g.getAttribute("couleur"));
        }
        return calculeNombreConflits(g);
    }
}
