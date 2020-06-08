/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gos.controle;

import br.com.gos.dao.ModuloConexao;
import br.com.gos.modelo.LojaModelo;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author dv22p
 */
public class LojaControle
{
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public LojaControle()
    {
        con = ModuloConexao.conector();
    }
    
    public void addLoja(LojaModelo lm)
    {
        try 
        {
            pst=con.prepareStatement("insert into loja(nome,cnpj,fone,email,cadastro,pgto,bloqueado,mensagem) values(?,?,?,?,?,?,?,?)");
            pst.setString(1, lm.getNome());
            pst.setString(2, lm.getCnpj());
            pst.setString(3, lm.getFone());
            pst.setString(4, lm.getEmail());
            pst.setString(5, lm.getCadastro());
            pst.setString(6, lm.getPgto());
            pst.setString(7, lm.getBloqueado());
            pst.setString(8, lm.getMensagem());
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
            System.out.println("Erro ao inserir loja\n"+e);
        }
    }
    
    public void altLoja(LojaModelo lm)
    {
        try 
        {
            pst=con.prepareStatement("update loja set nome=?,cnpj=?,fone=?,email=?,cadastro=?,pgto=?,bloqueado=?,mensagem=? where id=?");
            pst.setString(1, lm.getNome());
            pst.setString(2, lm.getCnpj());
            pst.setString(3, lm.getFone());
            pst.setString(4, lm.getEmail());
            pst.setString(5, lm.getCadastro());
            pst.setString(6, lm.getPgto());
            pst.setString(7, lm.getBloqueado());
            pst.setString(8, lm.getMensagem());
            pst.setString(9, lm.getId());
            int ok = pst.executeUpdate();
            if (ok>0)
            {
                JOptionPane.showMessageDialog(null,"Alterado com sucesso!");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Falha ao alterado!");
            }
        } 
        catch (HeadlessException | SQLException e) 
        {
            System.out.println("Erro ao alterar loja:\n"+e);
        }
    }
    
    public void excLoja(LojaModelo lm)
    {
        try 
        {
            pst=con.prepareStatement("delete from loja where id=?");
            pst.setString(1, lm.getId());
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
            System.out.println("Erro ao apagar loja:\n"+e);
        }
    }
    
    public void retornaUltimoRegistro(LojaModelo lm)
    {
        try 
        {
            pst = con.prepareStatement("select max(id) from loja");
            rs = pst.executeQuery();
            if (rs.next()) 
            {
                lm.setId(rs.getString("max(id)"));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Erro ao retornar ultimo registro de loja:\n"+e);
        }
    }
    
    public void buscaLojaId(LojaModelo lm)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try 
        {
            pst=con.prepareStatement("select * from loja where id=?");
            pst.setString(1, lm.getId());
            rs=pst.executeQuery();
            if (rs.next())
            {
                lm.setNome(rs.getString("nome"));
                lm.setCnpj(rs.getString("cnpj"));
                lm.setFone(rs.getString("fone"));
                lm.setEmail(rs.getString("email"));
                lm.setCadastro(sdf.format(rs.getDate("cadastro")));
                lm.setPgto(rs.getString("pgto"));
                lm.setBloqueado(rs.getString("bloqueado"));
                lm.setMensagem(rs.getString("mensagem"));
            }
        }
        catch (SQLException e) 
        {
            System.out.println("Erro ao retornar dados loja:\n"+e);
        }
    }
    
    public void pesqLojas(LojaModelo lm, JTable jTable)
    {
        try
        {
            pst = con.prepareStatement("select id as Código,nome as Nome,cnpj as CNPJ from loja where nome like ?");
            pst.setString(1,"%" + lm.getNome().replace(" ","%") + "%");
            rs = pst.executeQuery();
            jTable.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (SQLException e) 
        {
            System.out.println("Erro ao pesquisar loja:\n"+e);
        }
    }
}
