/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sae202_etu;
import Groupes.Groupe12.*;
import org.graphstream.graph.Graph;
import static packMesClassesEtInterfaces.SAE202_Algos.charger_graphe;

/**
 *
 * @author brice.effantin
 */
public class SAE202_etu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int milli=0;
        Groupe12 test= new Groupe12();
        test.chargerGraphe("colo-test0.txt");
         long temps = System.currentTimeMillis();
        test.colorierAlea(test.getGraph(),milli);
        System.out.println( System.currentTimeMillis() - temps);

        
    }
    
}