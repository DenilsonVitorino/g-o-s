/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gos.util;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author dv22p
 */
public class GerenteFecha extends JInternalFrame 
{
    public static void dialogoFechaJanela(JInternalFrame jInternalFrame, JTextField jTextField, JButton jButton)
    {
        jInternalFrame.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
        if (jTextField.isEnabled())
        {
            int sair = JOptionPane.showConfirmDialog(null,"Deseja cancelar a edição?\nTodos os dados serão perdidos!","Atenção",JOptionPane.YES_NO_OPTION);
            if (sair==JOptionPane.YES_OPTION) 
            {
                jInternalFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
                if (jButton.isVisible()) 
                {
                    jButton.doClick();
                }
            }
        }
        else
        {
            jInternalFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        }
    }
}
