/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gos.controle;

import br.com.gos.dao.ModuloConexao;
import br.com.gos.modelo.ClientesModelo;
import static br.com.gos.visao.FrmPrincipal.numeroLoja;
import java.awt.HeadlessException;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author dv22p
 */
public class ClientesControle
{
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public ClientesControle() 
    {
        con = ModuloConexao.conector();
    }
    
    public void addCliente(ClientesModelo cm)
    {
        try 
        {
            pst=con.prepareStatement("insert into clientes(nome,cpf,endereco,fone,email,alterado,responsavel,idloja) values(?,?,?,?,?,now(),?,?)");
            pst.setString(1, cm.getNome());
            pst.setString(2, cm.getCpf());
            pst.setString(3, cm.getEndereco());
            pst.setString(4, cm.getFone());
            pst.setString(5, cm.getEmail());
            pst.setString(6, cm.getResponsavel());
            pst.setString(7, numeroLoja);
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
            System.out.println("Erro ao inserir cliente:\n"+e);
        }
    }
    
    public void altCliente(ClientesModelo cm)
    {
        try 
        {
            pst=con.prepareStatement("update clientes set nome=?,cpf=?,endereco=?,fone=?,email=?,alterado=now(),responsavel=? where id=?");
            pst.setString(1, cm.getNome());
            pst.setString(2, cm.getCpf());
            pst.setString(3, cm.getEndereco());
            pst.setString(4, cm.getFone());
            pst.setString(5, cm.getEmail());
            pst.setString(6, cm.getResponsavel());
            pst.setString(7, cm.getId());
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
            System.out.println("Erro ao alterar cliente:\n"+e);
        }
    }
    
    public void excCliente(ClientesModelo cm)
    {
        try 
        {
            pst=con.prepareStatement("delete from clientes where id=?");
            pst.setString(1, cm.getId());
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
            System.out.println("Erro ao excluir cliente:\n"+e);
        }
    }
    
    public void retornaUltimoRegistro(ClientesModelo cm)
    {
        try 
        {
            pst = con.prepareStatement("select max(id) from clientes where idloja="+numeroLoja);
            rs = pst.executeQuery();
            if (rs.next()) 
            {
                cm.setId(rs.getString("max(id)"));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Erro ao retornar ultimo registro de cliente:\n"+e);
        }
    }
    
    public void buscaClienteId(ClientesModelo cm)
    {
        try 
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  -  HH:mm:ss");
            pst = con.prepareStatement("select * from clientes where id=?");
            pst.setString(1, cm.getId());
            rs = pst.executeQuery();
            if (rs.next())
            {
                cm.setNome(rs.getString("nome"));
                cm.setCpf(rs.getString("cpf"));
                cm.setEndereco(rs.getString("endereco"));
                cm.setFone(rs.getString("fone"));
                cm.setEmail(rs.getString("email"));
                cm.setAlterado(sdf.format(rs.getTimestamp("alterado")));
                cm.setResponsavel(rs.getString("responsavel"));
            }
        } 
        catch (SQLException e)
        {
            System.out.println("Erro ao buscar cliente pelo id:\n"+e);
        }
    }
    
    public void pesqUsuarios(ClientesModelo cm, JTable jTable)
    {
         try
         {
             pst = con.prepareStatement("select id as Código,nome as Nome,cpf as CPF from clientes where nome like ? and idloja="+numeroLoja);
             pst.setString(1,"%" + cm.getNome().replace(" ","%") + "%");
             rs = pst.executeQuery();
             jTable.setModel(DbUtils.resultSetToTableModel(rs));
         } 
         catch (SQLException e) 
         {
             System.out.println("Erro ao pesquisar clientes:\n"+e);
         }
     }
}
