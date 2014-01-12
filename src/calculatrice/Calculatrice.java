/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatrice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author mama
 * 
*/
public class Calculatrice implements ActionListener {

    /**
     * Instance de la vue (affichage de la calculette)
     */
    private VueCalculatrice vue = null;
    /**
     * Flag indiquant si le point a ete utilise ou non.
     */
    private boolean point = false;
    /**
     * Flag indiquant si on est entrain d'afficher le resultat ou non.
     */
    private boolean modeResultat = false;
    /**
     * Contient la valeur venant d'etre entree.
     */
    private float valeur = 0;
    /**
     * Contient le resultat de l'operation.
     */
    private float resultat = 0;
    /**
     * Contient le type de la derniere operation.
     */
    private String operation = "";
    /**
     * Flag indiquant si on commence un nouveau calcul.
     */
    private boolean debutCalcul = true;

    /**
     * Point d'entree de l'application.
     *
     * @param args
     */
    public static void main(String[] args) {
        new Calculatrice();
    }

    /**
     * Constructeur de Calculette.
     *
     */
    public Calculatrice() {
        vue = new VueCalculatrice(this);

    }

    /**
     * Methode de gestion des evenements bouton.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String orig = e.getActionCommand();
        try {
            int i = new Integer(orig).intValue();
            if (modeResultat) {
                vue.clear();
                modeResultat = false;
            }

            vue.ajoutChiffre(orig);
        } catch (NumberFormatException nfe) {
            if (orig.equals(".") && !point) {
                point = true;
                vue.ajoutChiffre(orig);
            }

            if (orig.equals("/")) {
                modeResultat = true;
                if (operation.equals("")) {
                    operation = orig;
                }
                operation();
                operation = orig;
            }

            if (orig.equals("X")) {
                modeResultat = true;
                if (operation.equals("")) {
                    operation = orig;
                }
                operation();
                operation = orig;
            }

            if (orig.equals("+")) {
                modeResultat = true;
                if (operation.equals("")) {
                    operation = orig;
                }
                operation();
                operation = orig;
            }

            if (orig.equals("-")) {
                modeResultat = true;
                if (operation.equals("")) {
                    operation = orig;
                }
                operation();
                operation = orig;
            }

            if (orig.equals("=")) {
                modeResultat = true;
                operation();
                operation = "";
                resultat = 0;
                debutCalcul = true;
            }

            if (orig.equals("C")) {
                vue.clear();
            }

            if (orig.equals("RAZ")) {
                raz();
            }
        }
    }

    /**
     * Methode permettant le renvoi sur l'operation demandee.
     *
     */
    private void operation() {
        if (operation.equals("+")) {
            addition(vue.getNombre());
        }
        if (operation.equals("-")) {
            soustraction(vue.getNombre());
        }
        if (operation.equals("X")) {
            multiplication(vue.getNombre());
        }
        if (operation.equals("/")) {
            division(vue.getNombre());
        }
    }

    /**
     * Operation d'addition.
     *
     * @param nb float contenant la valeur a additionner.
     */
    private void addition(float nb) {
        System.out.println("Nb1 =" + resultat + " nb2 =" + nb);
        resultat = resultat + nb;
        System.out.println("Res =" + resultat);
        vue.afficher(resultat);
    }

    /**
     * Operation de soustraction.
     *
     * @param nb float contenant la valeur � soustraire.
     */
    private void soustraction(float nb) {
        System.out.println("Nb1 =" + resultat + " nb2 =" + nb);
        if (debutCalcul) {
            debutCalcul = false;
            resultat = nb;
        } else {
            resultat = resultat - nb;
        }
        System.out.println("Res =" + resultat);
        vue.afficher(resultat);
    }

    /**
     * Operation de multiplication.
     *
     * @param nb float contenant la valeur a multiplier.
     */
    private void multiplication(float nb) {
        System.out.println("Nb1 =" + resultat + " nb2 =" + nb);
        if (debutCalcul) {
            debutCalcul = false;
            resultat = nb;
        } else {
            resultat = resultat * nb;
        }
        System.out.println("Res =" + resultat);
        vue.afficher(resultat);
    }

    /**
     * Operation de division.
     *
     * @param nb float contenant la valeur a diviser.
     */
    private void division(float nb) {
        System.out.println("Nb1 =" + resultat + " nb2 =" + nb);
        if (debutCalcul) {
            debutCalcul = false;
            resultat = nb;
        } else {
            resultat = resultat / nb;
        }
        System.out.println("Res =" + resultat);
        vue.afficher(resultat);
    }

    /**
     * Remise a zero de la calculette.
     *
     */
    public void raz() {
        vue.clear();
        resultat = 0;
        valeur = 0;
        debutCalcul = true;
        operation = "";
        modeResultat = false;
    }

    /**
     * Lance le son "sound.mp3" dans un thread
     */
    public void lanceSon() {
        //TODO: implémenter la méthode
    }
}
