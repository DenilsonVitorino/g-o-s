/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gos.controle;

import br.com.gos.dao.ModuloConexao;
import br.com.gos.modelo.UsuariosModelo;
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
public class UsuariosControle 
{
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private int contaErro;
    public UsuariosControle() 
    {
        con = ModuloConexao.conector();
        contaErro=0;
    }
    
    public void addUsuario(UsuariosModelo um)
    {
        try 
        {
            pst=con.prepareStatement("select * from usuarios where login=?");
            pst.setString(1, um.getLogin());
            
            rs=pst.executeQuery();
            if (rs.next())
            {
                JOptionPane.showMessageDialog(null,"Login já existente!");
            }
            else
            {
                try 
                {
                    pst=con.prepareStatement("insert into usuarios(nome,login,senha,perfil,alterado,responsavel,idloja) values(?,?,?,?,now(),?,?)");
                    pst.setString(1, um.getNome());
                    pst.setString(2, um.getLogin());
                    pst.setString(3, um.getSenha());
                    pst.setString(4, um.getPerfil());
                    pst.setString(5, um.getResponsavel());
                    pst.setString(6, numeroLoja);
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
                catch (SQLException e)
                {
                    System.out.println("Erro ao inserir usuario:\n"+e);
                }
            }
        }
        catch (HeadlessException | SQLException e) 
        {
            System.out.println("Erro ao pesquisar usuario antes de inserir:\n"+e);
        }
    }

    public void altUsuario(UsuariosModelo um)
    {
        try 
        {
            pst = con.prepareStatement("update usuarios set nome=?, login=?, senha=?, perfil=?, alterado=now(), responsavel=? where id=?");
            pst.setString(1, um.getNome());
            pst.setString(2, um.getLogin());
            pst.setString(3, um.getSenha());
            pst.setString(4, um.getPerfil());
            pst.setString(5, um.getResponsavel());
            pst.setString(6, um.getId());
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
            System.out.println("Erro ao alterar usuario:\n"+e);
        }
    }
    
    public void excUsuario(UsuariosModelo um)
    {
        try 
        {
           pst = con.prepareStatement("delete from usuarios where id=?");
           pst.setString(1, um.getId());
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
            System.out.println("Erro ao excluir usuario:\n"+e); 
        }
    }
    
    public void logaUsuario(UsuariosModelo um)
    {
        try 
        {
            String login,senha=null;
            login=um.getLogin();
            senha=um.getSenha();
            pst = con.prepareStatement("select * from usuarios where ((id='"+login+"') or (login='"+login+"')) and senha='"+senha+"'");
            rs=pst.executeQuery();
            if (rs.next()) 
            {
                um.setNome(rs.getString("nome"));
                um.setPerfil(rs.getString("perfil"));
                um.setLoja(rs.getString("idloja"));
            }
            else
            {
                String msg="";
                contaErro=contaErro+1;
                switch(contaErro)
                {
                    case 1: msg="Primeira Tentativa!";
                       break;
                    case 2: msg="Segunda Tentativa!";
                       break;
                    case 3: msg="Terceira e Última Tentativa!\nO software será encerrado!";
                       break;
                    default: msg="Acesso negado!";
                }
                JOptionPane.showMessageDialog(null,"Acesso negado!\n"+msg);
                if (contaErro==3) 
                {
                    System.exit(0);
                }
            }
        }
        catch (SQLException e) 
        {
            System.out.println("Erro ao logar usuario:\n"+e);
        }
    }
    
    public void retornaUltimoRegistro(UsuariosModelo um)
    {
        try 
        {
            pst = con.prepareStatement("select max(id) from usuarios where idloja="+numeroLoja);
            rs = pst.executeQuery();
            if (rs.next()) 
            {
                um.setId(rs.getString("max(id)"));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Erro ao retornar ultimo registro de usuario:\n"+e);
        }
    }
    
    public void buscaUsuarioId(UsuariosModelo um)
    {
        try 
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  -  HH:mm:ss");
            pst = con.prepareStatement("select * from usuarios where id=?");
            pst.setString(1, um.getId());
            rs = pst.executeQuery();
            if (rs.next())
            {
                um.setNome(rs.getString("nome"));
                um.setLogin(rs.getString("login"));
                um.setSenha(rs.getString("senha"));
                um.setPerfil(rs.getString("perfil"));
                um.setAlterado(sdf.format(rs.getTimestamp("alterado")));
                um.setResponsavel(rs.getString("responsavel"));
            }
        } 
        catch (SQLException e)
        {
            System.out.println("Erro ao buscar usuario pelo id:\n"+e);
        }
    }
    
    public void pesqUsuarios(UsuariosModelo um, JTable jTable)
    {
         try
         {
             pst = con.prepareStatement("select id as Código, nome as Nome, perfil as Perfil from usuarios where nome like ? and idloja="+numeroLoja);
             pst.setString(1,"%" + um.getNome().replace(" ", "%") + "%");
             rs = pst.executeQuery();
             jTable.setModel(DbUtils.resultSetToTableModel(rs));
         } 
         catch (SQLException e) 
         {
             System.out.println("Erro ao pesquisar usuario:\n"+e);
         }
     }
    
    public void atualizaLoja(UsuariosModelo um)
    {
        try 
        {
            pst=con.prepareStatement("update usuarios set idloja=? where id=?");
            pst.setString(1, um.getLoja());
            pst.setString(2, um.getId());
            int ok = pst.executeUpdate();
            if (ok>0)
            {
                JOptionPane.showMessageDialog(null,"Cadastro completo!");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Falha ao finalizar cadastro!");
            }
        } 
        catch (HeadlessException | SQLException e)
        {
            System.out.println("Erro ao selecionar loja:\n"+e);
        }
    }
} 