/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sae202_etu;
import Groupes.Groupe12.*;
import java.math.BigInteger;
import org.graphstream.graph.Graph;
import static packMesClassesEtInterfaces.SAE202_Algos.charger_graphe;

/**
 * Classe main
 * @author brice.effantin
 */
public class SAE202_etu {
/**
 * Constructeur par défaut
 */
    public SAE202_etu() {
    }

    /**
     * Classe main
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here

        long milli = 4000000;
        Groupe12 test= new Groupe12();
        test.challenge("colo-test",20,milli);
            test.modelisation("colo-test", 20, milli);
    }
    
}