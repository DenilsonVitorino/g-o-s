
package br.com.gos.dao;
import java.sql.*;

public class ModuloConexao
{
    public static Connection conector()
    {
        java.sql.Connection conexao = null;
        try 
        {
           Class.forName("com.mysql.jdbc.Driver");
           conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gos","root","cavalera845022");
           return conexao;
        }
        catch (ClassNotFoundException | SQLException e) 
        {
           return null;
        }   
    }
}
