/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculatrice;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;


/**
* @author mama
*
*/
public class VueCalculatrice extends JFrame implements WindowListener
{
        private javax.swing.JPanel pnlPrincipal = null;
        private javax.swing.JPanel pnlNombres = null;
        private javax.swing.JPanel pnlOperateurs = null;
        private javax.swing.JButton btnDiv = null;
        private javax.swing.JButton btnPlus = null;
        private javax.swing.JButton btnMoins = null;
        private javax.swing.JButton btnMult = null;
        private javax.swing.JButton btnC = null;
        private javax.swing.JButton btnRAZ = null;
        private javax.swing.JButton btnEgale = null;
        private javax.swing.JTextField txtSaisie = null;
        private boolean cleared = true;
        private ActionListener action = null;
        
        public VueCalculatrice(ActionListener action)
        {
                super();
                this.action = action;
                initialize();
        }
        private void initialize()
        {
                this.setSize(229, 279);
                this.setContentPane(getPnlPrincipal());
                this.setResizable(false);
                this.addWindowListener(this);
                this.show();
        }
        private javax.swing.JPanel getPnlPrincipal()
        {
                if (pnlPrincipal == null)
                {
                        pnlPrincipal = new javax.swing.JPanel();
                        pnlPrincipal.setLayout(null);
                        pnlPrincipal.add(getPnlNombres(), null);
                        pnlPrincipal.add(getPnlOperateurs(), null);
                        pnlPrincipal.add(getBtnC(), null);
                        pnlPrincipal.add(getBtnRAZ(), null);
                        pnlPrincipal.add(getBtnEgale(), null);
                        pnlPrincipal.add(getTxtSaisie(), null);
                }
                return pnlPrincipal;
        }
        private javax.swing.JPanel getPnlNombres()
        {
                if (pnlNombres == null)
                {
                        pnlNombres = new javax.swing.JPanel();
                        pnlNombres.setBounds(35, 57, 120, 146);
                        for (int i = 7; i > -3; i = i - 3)
                        {
                                for (int j = 0; j < 3; j++)
                                {
                                        if ((i + j) != 0)
                                        {
                                                JButton btn = new JButton();
                                                btn.setPreferredSize(new java.awt.Dimension(30, 30));
                                                btn.setMargin(new java.awt.Insets(0, 0, 0, 0));
                                                btn.setFont(
                                                        new java.awt.Font(
                                                                "Dialog",
                                                                java.awt.Font.BOLD,
                                                                24));
                                                if ((i + j) == -2)
                                                        btn.setText("0");
                                                if ((i + j) == -1)
                                                        btn.setText(".");
                                                if ((i + j) > 0)
                                                        btn.setText(String.valueOf(i + j));
                                                btn.addActionListener(action);
                                                pnlNombres.add(btn);
                                        }
                                }
                        }
                }
                return pnlNombres;
        }
        private javax.swing.JPanel getPnlOperateurs()
        {
                if (pnlOperateurs == null)
                {
                        pnlOperateurs = new javax.swing.JPanel();
                        pnlOperateurs.add(getBtnPlus(), null);
                        pnlOperateurs.add(getBtnMoins(), null);
                        pnlOperateurs.add(getBtnDiv(), null);
                        pnlOperateurs.add(getBtnMult(), null);
                        pnlOperateurs.setSize(30, 146);
                        pnlOperateurs.setLocation(176, 57);
                        pnlOperateurs.setAlignmentY(0.5F);
                }
                return pnlOperateurs;
        }
        private javax.swing.JButton getBtnDiv()
        {
                if (btnDiv == null)
                {
                        btnDiv = new javax.swing.JButton();
                        btnDiv.setPreferredSize(new java.awt.Dimension(30, 30));
                        btnDiv.setMargin(new java.awt.Insets(0, 0, 0, 0));
                        btnDiv.setText("/");
                        btnDiv.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 24));
                        btnDiv.addActionListener(action);
                }
                return btnDiv;
        }
        private javax.swing.JButton getBtnPlus()
        {
                if (btnPlus == null)
                {
                        btnPlus = new javax.swing.JButton();
                        btnPlus.setPreferredSize(new java.awt.Dimension(30, 30));
                        btnPlus.setMargin(new java.awt.Insets(0, 0, 0, 0));
                        btnPlus.setText("+");
                        btnPlus.setFont(
                                new java.awt.Font("Dialog", java.awt.Font.BOLD, 24));
                        btnPlus.addActionListener(action);
                }
                return btnPlus;
        }
        private javax.swing.JButton getBtnMoins()
        {
                if (btnMoins == null)
                {
                        btnMoins = new javax.swing.JButton();
                        btnMoins.setPreferredSize(new java.awt.Dimension(30, 30));
                        btnMoins.setMargin(new java.awt.Insets(0, 0, 0, 0));
                        btnMoins.setText("-");
                        btnMoins.setFont(
                                new java.awt.Font("Dialog", java.awt.Font.BOLD, 24));
                        btnMoins.addActionListener(action);
                }
                return btnMoins;
        }
        private javax.swing.JButton getBtnMult()
        {
                if (btnMult == null)
                {
                        btnMult = new javax.swing.JButton();
                        btnMult.setPreferredSize(new java.awt.Dimension(30, 30));
                        btnMult.setMargin(new java.awt.Insets(0, 0, 0, 0));
                        btnMult.setText("x");
                        btnMult.setFont(
                                new java.awt.Font("Dialog", java.awt.Font.BOLD, 24));
                        btnMult.setActionCommand("X");
                        btnMult.addActionListener(action);
                }
                return btnMult;
        }
        private javax.swing.JButton getBtnC()
        {
                if (btnC == null)
                {
                        btnC = new javax.swing.JButton();
                        btnC.setSize(30, 30);
                        btnC.setText("C");
                        btnC.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
                        btnC.setAlignmentY(0.0F);
                        btnC.setLocation(176, 20);
                        btnC.setMargin(new java.awt.Insets(0, 0, 0, 0));
                        btnC.addActionListener(action);
                }
                return btnC;
        }
        private javax.swing.JButton getBtnRAZ()
        {
                if (btnRAZ == null)
                {
                        btnRAZ = new javax.swing.JButton();
                        btnRAZ.setBounds(176, 210, 30, 30);
                        btnRAZ.setMargin(new java.awt.Insets(0, 0, 0, 0));
                        btnRAZ.setText("#");
                        btnRAZ.setActionCommand("RAZ");
                        btnRAZ.addActionListener(action);
                }
                return btnRAZ;
        }
        private javax.swing.JButton getBtnEgale()
        {
                if (btnEgale == null)
                {
                        btnEgale = new javax.swing.JButton();
                        btnEgale.setBounds(20, 210, 150, 30);
                        btnEgale.setText("=");
                        btnEgale.setFont(
                                new java.awt.Font("Dialog", java.awt.Font.BOLD, 24));
                        btnEgale.addActionListener(action);
                }
                return btnEgale;
        }
        private javax.swing.JTextField getTxtSaisie()
        {
                if (txtSaisie == null)
                {
                        txtSaisie = new javax.swing.JTextField();
                        txtSaisie.setBounds(20, 20, 150, 30);
                        txtSaisie.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
                        txtSaisie.setText("0");
                        txtSaisie.setFont(
                                new java.awt.Font("Dialog", java.awt.Font.BOLD, 24));
                        txtSaisie.setEditable(false);
                }
                return txtSaisie;
        }
        public void clear()
        {
                getTxtSaisie().setText("0");
                cleared = true;
        }
        /**
         * Permet d'afficher le resultat.
         * @param resultat float contenant le résultat.
         */
        public void afficher(float resultat)
        {
                String s = String.valueOf(resultat);
                if (s.substring(s.length() - 2).equals(".0"))
                        s = s.substring(0, s.length() - 2);
                getTxtSaisie().setText(s);
        }
        /**
         * Permet d'ajouter un chiffre à l'afficheur.
         * @param chaine contient le chiffre à ajouter.
         */
        public void ajoutChiffre(String chaine)
        {
                if (cleared)
                {
                        cleared = false;
                        getTxtSaisie().setText("");
                }
                String s = getTxtSaisie().getText();
                if (s.length() != 11)
                {
                        getTxtSaisie().setText(s + chaine);
                }
        }
        /**
         * Retourne la valeur du nombre affiché.
         * @return un float contenant le nombre.
         */
        public float getNombre()
        {
                String s = getTxtSaisie().getText();
                return new Float(s).floatValue();
        }
        public void windowActivated(WindowEvent e)
        {
        }
        public void windowClosed(WindowEvent e)
        {
        }
        public void windowClosing(WindowEvent e)
        {
                System.exit(0);
        }
        public void windowDeactivated(WindowEvent e)
        {
        }
        public void windowDeiconified(WindowEvent e)
        {
        }
        public void windowIconified(WindowEvent e)
        {
        }
        public void windowOpened(WindowEvent e)
        {
        }
}