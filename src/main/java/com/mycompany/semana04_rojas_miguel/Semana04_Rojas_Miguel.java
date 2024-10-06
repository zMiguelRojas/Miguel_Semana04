/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana04_rojas_miguel;

import Vista.Registro;

/**
 *
 * @author miguel
 */
public class Semana04_Rojas_Miguel {

    public static void main(String[] args) {
        try {
            // Set HiFi Look and Feel from JTattoo
            javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Semana04_Rojas_Miguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Semana04_Rojas_Miguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Semana04_Rojas_Miguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Semana04_Rojas_Miguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

         java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Registro().setVisible(true);
        }
    });
    }
}
