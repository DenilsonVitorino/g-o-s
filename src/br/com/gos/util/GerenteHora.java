/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gos.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author dv22p
 */
public class GerenteHora extends Thread
{
    private JLabel hr;
    private boolean mostrarHora;
    public GerenteHora(JLabel hora)
    {
        this.hr = hora;
    }
    public void mostrarHora(boolean mostrar)
    {
        if (mostrar)
        {
            this.mostrarHora=true;
        }
        else
        {
            this.mostrarHora=false;
        }
    }
    @Override
    public void run()
    {
        try 
        {
            while (true)
            {
                Date d = new Date();
                StringBuffer data = new StringBuffer();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                this.hr.setText(data.toString() + sdf.format(d));
                Thread.sleep(1000);
                this.hr.revalidate();
            }
        }
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
}
