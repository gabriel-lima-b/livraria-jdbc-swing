/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;

/**
 *
 * @author jbferraz
 */
public class Conexao {

    //cria constante com endereço do BD e schema
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    private static String url = "jdbc:mysql://localhost:3306/devn211";
    //cria uma constante com user do BD
    private static String user = "sa";
    //cria uma constante com senha do BD
    private static String pass = "";

    private static Connection c = null;
    private static Statement stmt = null;

    public static void sobeDB() {
        getConexao();
        criaTabelaClientes();
    }

    public static Connection getConexao() {
        //Inicia conexão nula, ainda não estabelecida
        //tenta estabelecer a conexão
        try {
            // STEP 1: Register JDBC driver 
            Class.forName(JDBC_DRIVER);
            c = DriverManager.getConnection(DB_URL, user, pass);
            System.out.println("Banco conectado!");
            //caso haja alguma falha entra no catch
        } catch (SQLException e) {
            System.out.println("Erro ao conectar banco!\n"
                    + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public static void desconectarBanco() {
        System.out.println("Desconectando banco.");
        try {
            c.close();
        } catch (SQLException ex) {
            System.out.println("erro ao desconectar banco.");
        }
        System.out.println("Banco desconectado.");
    }

    private static void criaTabelaClientes() {
        try {
            stmt = c.createStatement();
            String sql = "CREATE TABLE  CLIENTE"
                    + "(id INTEGER not NULL AUTO INCREMENT, "
                    + " nomeCliente VARCHAR(255), "
                    + " cpf VARCHAR(255), "
                    + " cnpj INTEGER, "
                    + " endereco VARCHAR(255), "
                    + " telefone VARCHAR(255), "
                    + " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);

            sql = "insert into cliente values (null,Juventino Florencio, 123, null, Flores da Cunha, 51 44334433)";
            stmt.execute(sql);
            sql = "insert into cliente values (null,Josnelson das Candongas, 321, null, Dorival de Oliveira, 51 9 99998888)";
            stmt.execute(sql);
            System.out.println("Tabela cliente criada.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela cliente.");
        }
    }
}
