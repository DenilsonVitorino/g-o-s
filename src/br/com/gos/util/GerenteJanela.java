/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gos.util;

import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author dv22p
 */
public class GerenteJanela
{
    public static JDesktopPane jDesktopPane;
    public GerenteJanela(JDesktopPane jDesktopPane)
    {
        GerenteJanela.jDesktopPane=jDesktopPane;
    }
    
    public void abreJanela(JInternalFrame jInternalFrame)
    {
        if (jInternalFrame.isVisible())
        {
            jInternalFrame.moveToFront();
            jInternalFrame.requestFocus();
        }
        else
        {
            jDesktopPane.add(jInternalFrame);
            jInternalFrame.setVisible(true);
            try 
            {
                jInternalFrame.setMaximizable(true);
                jInternalFrame.setMaximum(true);
            } 
            catch (PropertyVetoException e) 
            {
            }
        }
    }
}
