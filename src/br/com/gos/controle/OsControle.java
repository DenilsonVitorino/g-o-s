/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gos.controle;

import br.com.gos.dao.ModuloConexao;
import br.com.gos.modelo.OsModelo;
import static br.com.gos.visao.FrmPrincipal.numeroLoja;
import java.awt.HeadlessException;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import java.util.Date;

/**
 *
 * @author dv22p
 */
public class OsControle
{
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public OsControle()
    {
        con = ModuloConexao.conector();
    }
    
    public void addOs(OsModelo om)
    {
        try 
        {
            pst=con.prepareStatement("insert into os(emissao,tipo,situacao,equipamento,defeito,servico,entrega,valor,idcliente,nomecliente,alterado,responsavel,idloja) values(now(),?,?,?,?,?,?,?,?,?,now(),?,?)");
            pst.setString(1, om.getTipo());
            pst.setString(2, om.getSituacao());
            pst.setString(3, om.getEquipamento());
            pst.setString(4, om.getDefeito());
            pst.setString(5, om.getServico());
            pst.setString(6, om.getEntrega());
            pst.setString(7, om.getValor());
            pst.setString(8, om.getIdCliente());
            pst.setString(9, om.getNomeCliente());
            pst.setString(10, om.getResponsavel());
            pst.setString(11, numeroLoja);
            int ok = pst.executeUpdate();
            if (ok>0)
            {
                JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Falha ao cadastrar!");
            }
        } 
        catch (HeadlessException | SQLException e) 
        {
            System.out.println("Erro ao inserir os:\n"+e);   
        }
    }
    
    public void altOs(OsModelo om)
    {
        try 
        {
            pst=con.prepareStatement("update os set tipo=?,situacao=?,equipamento=?,defeito=?,servico=?,entrega=?,valor=?,idcliente=?,nomecliente=?,alterado=now(),responsavel=? where os=?");
            pst.setString(1, om.getTipo());
            pst.setString(2, om.getSituacao());
            pst.setString(3, om.getEquipamento());
            pst.setString(4, om.getDefeito());
            pst.setString(5, om.getServico());
            pst.setString(6, om.getEntrega());
            pst.setString(7, om.getValor());
            pst.setString(8, om.getIdCliente());
            pst.setString(9, om.getNomeCliente());
            pst.setString(10, om.getResponsavel());
            pst.setString(11, om.getOs());
            int ok = pst.executeUpdate();
            if (ok>0)
            {
                JOptionPane.showMessageDialog(null,"Alterado com sucesso!");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Falha ao alterar!");
            }
        }
        catch (HeadlessException | SQLException e) 
        {
            System.out.println("Erro ao alterar os:\n"+e);
        }
    }
    
    public void excOs(OsModelo om)
    {
        try 
        {
            pst=con.prepareStatement("delete from os where os=?");
            pst.setString(1, om.getOs());
            int ok = pst.executeUpdate();
            if (ok>0)
            {
                JOptionPane.showMessageDialog(null,"Removido com sucesso!");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Falha ao remover!");
            }
        } 
        catch (HeadlessException | SQLException e)
        {
            System.out.println("Erro ao remover os:\n"+e);  
        }
    }
    
    public void retornaUltimoRegistro(OsModelo om)
    {
        try 
        {
            pst = con.prepareStatement("select max(os) from os where idloja="+numeroLoja);
            rs = pst.executeQuery();
            if (rs.next()) 
            {
                om.setOs(rs.getString("max(os)"));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Erro ao retornar ultimo registro de os:\n"+e);
        }
    }
    
    public void buscaOs(OsModelo om)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  -  HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        try 
        {
            pst = con.prepareStatement("select * from os where os=?");
            pst.setString(1, om.getOs());
            rs = pst.executeQuery();
            if (rs.next())
            {
                om.setEmissao(sdf.format(rs.getTimestamp("emissao")));
                om.setTipo(rs.getString("tipo"));
                om.setSituacao(rs.getString("situacao"));
                om.setEquipamento(rs.getString("equipamento"));
                om.setDefeito(rs.getString("defeito"));
                om.setServico(rs.getString("servico"));
                om.setEntrega(sdf2.format(rs.getDate("entrega")));
                om.setValor(rs.getString("valor"));
                om.setIdCliente(rs.getString("idcliente"));
                om.setNomeCliente(rs.getString("nomecliente"));
                om.setAlterado(sdf.format(rs.getTimestamp("alterado")));
                om.setResponsavel(rs.getString("responsavel"));
            }
        } 
        catch (SQLException e)
        {
            System.out.println("Erro ao buscar os pela os:\n"+e);
        }
    }
    
    public void pesqOs(OsModelo om, JTable jTable)
    {
         try
         {
             pst = con.prepareStatement("select os as Código,nomecliente as 'Nome do Cliente',tipo as Tipo,date_format(emissao, '%d/%m/%Y%H:%m:%s') as Emissão from os where nomecliente like ? and idloja="+numeroLoja);
             pst.setString(1,"%" + om.getNomeCliente().replace(" ","%") + "%");
             rs = pst.executeQuery();
             jTable.setModel(DbUtils.resultSetToTableModel(rs));
         } 
         catch (SQLException e) 
         {
             System.out.println("Erro ao pesquisar os:\n"+e);
         }
     }
    
    public void somaDia(OsModelo om)
    {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try 
        {
            pst=con.prepareStatement("select sum(valor) from os where emissao like ? and tipo='ORDEM DE SERVIÇO' and idloja="+numeroLoja);
            pst.setString(1, sdf.format(d) + "%");
            rs = pst.executeQuery();
            if (rs.next())
            {
                om.setTotalDia(rs.getString("sum(valor)"));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Erro ao somar dia:\n"+e);
        }
    }
    
    public void somaMes(OsModelo om)
    {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        try 
        {
            pst=con.prepareStatement("select sum(valor) from os where emissao like ? and tipo='ORDEM DE SERVIÇO' and idloja="+numeroLoja);
            pst.setString(1, sdf.format(d) + "%");
            rs = pst.executeQuery();
            if (rs.next())
            {
                om.setTotalMes(rs.getString("sum(valor)"));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Erro ao somar dia:\n"+e);
        }
    }
    
    public void pesqOsDia(OsModelo om, JTable jTable)
    {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         try
         {
             pst = con.prepareStatement("select os as Código,situacao as Situação,responsavel as Responsável,valor as Valor,date_format(emissao, '%d/%m/%Y%H:%m:%s') as Emissão from os where emissao like ? and tipo='ORDEM DE SERVIÇO' and idloja="+numeroLoja);
             pst.setString(1, sdf.format(d) + "%");
             rs = pst.executeQuery();
             jTable.setModel(DbUtils.resultSetToTableModel(rs));
         } 
         catch (SQLException e) 
         {
             System.out.println("Erro ao pesquisar os:\n"+e);
         }
     }
    
    public void pesqOsMes(OsModelo om, JTable jTable)
    {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
         try
         {
             pst = con.prepareStatement("select os as Código,situacao as Situação,responsavel as Responsável,valor as Valor,date_format(emissao, '%d/%m/%Y%H:%m:%s') as Emissão from os where emissao like ? and tipo='ORDEM DE SERVIÇO' and idloja="+numeroLoja);
             pst.setString(1, sdf.format(d) + "%");
             rs = pst.executeQuery();
             jTable.setModel(DbUtils.resultSetToTableModel(rs));
         } 
         catch (SQLException e) 
         {
             System.out.println("Erro ao pesquisar os:\n"+e);
         }
     }
}
