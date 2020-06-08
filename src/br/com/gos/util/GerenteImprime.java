/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gos.util;

import br.com.gos.dao.ModuloConexao;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author dv22p
 */
public class GerenteImprime
{
    Connection con = null;

    public GerenteImprime()
    {
        con = ModuloConexao.conector();
    }

    public void imprimir(int parametro, String caminho)
    {
        try
        {
            JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização do Relatório", true);
            viewer.setSize(860,500); 
            viewer.setLocationRelativeTo(null);
            HashMap hashMap = new HashMap();
            hashMap.put("loja",parametro);
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminho, hashMap, con);
            JasperViewer jrViewer = new JasperViewer(jasperPrint, true);
            viewer.getContentPane().add(jrViewer.getContentPane());
            viewer.setVisible(true);
            
        }
        catch (JRException e) 
        {
            System.out.println("Erro ao imprimir:\n"+e);
        }
    }
    
    public void imprimir2(int parametro1, int parametro2, String caminho)
    {
         try
        {
            JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização do Relatório", true);
            viewer.setSize(860,500); 
            viewer.setLocationRelativeTo(null);
            HashMap hashMap = new HashMap();
            hashMap.put("loja",parametro1);
            hashMap.put("os", parametro2);
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminho, hashMap, con);
            JasperViewer jrViewer = new JasperViewer(jasperPrint, true);
            viewer.getContentPane().add(jrViewer.getContentPane());
            viewer.setVisible(true);
        }
        catch (JRException e) 
        {
            System.out.println("Erro ao imprimir2:\n"+e);
        }
    }
}
