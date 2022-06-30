/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import conexao.Conexao;
import model.Cliente;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author jbferraz
 */
public class ClienteDAO {
    
    public void cadastrarCliente(Cliente cVO) throws SQLException{
        //Busca conexão do BD
        Connection con = Conexao.getConexao();
        //cria espaço de trabalho sql, é a área no Java onde 
        //vamos executar os scripts SQL
        Statement stat = con.createStatement();
        
        try {
            String sql;
            sql = "insert into cliente values "
                    + "(null, '" 
                    + cVO.getNomeCliente()+ "', '"
                    + cVO.getCpf() + "', '"
                    + cVO.getCnpj()+ "', '"
                    + cVO.getEndereco() + "', '"
                    + cVO.getTelefone() + "');";
            //vamos executar no BD o SQl criado acima
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir Cliente! \n"
                + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }
    
    public ArrayList<Cliente> listarClientes() throws SQLException{
         //Busca conexão do BD
        Connection con = Conexao.getConexao();
        //cria espaço de trabalho sql, é a área no Java onde 
        //vamos executar os scripts SQL
        Statement stat = con.createStatement();
        
        try {
            String sql;
            sql = "select * from cliente";
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Cliente> clientes = new ArrayList<>();
            while(rs.next()){
                Cliente p = new Cliente();
                //lado do java |x| lado do BD
                p.setIdCliente(rs.getInt("idCliente"));
                p.setNomeCliente(rs.getString("nomeCliente"));
                p.setCpf(rs.getString("cpf"));
                p.setCnpj(rs.getString("cnpj"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                //popula arrayList
                clientes.add(p);
            }
            //retorna arrayList
            return clientes;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar clientes!\n" +
                    e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }
    
    public boolean verCPF(String cpf) throws SQLException{
        //Busca conexão do BD
        Connection con = Conexao.getConexao();
        //cria espaço de trabalho sql, é a área no Java onde 
        //vamos executar os scripts SQL
        Statement stat = con.createStatement();
        
        boolean verCPF = false;
        
        try {
            String sql;
            sql = "select cpf from cliente where cpf = '" + cpf + "'";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {                
                verCPF = rs.wasNull();
            }
        } catch (SQLException e) {
            throw new SQLException("Cliente com este CPF não existe! \n"
                + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
        return verCPF;
    }
    
    public Cliente getByDoc(String cpf) throws SQLException{
        //Busca conexão do BD
        Connection con = Conexao.getConexao();
        //cria espaço de trabalho sql, é a área no Java onde 
        //vamos executar os scripts SQL
        Statement stat = con.createStatement();
        Cliente p = new Cliente();
        
        try {
            String sql;
            sql = "select * from cliente where cpf = '" + cpf + "'";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {                
                //lado do java |x| lado do banco
                p.setIdCliente(rs.getInt("idCliente"));
                p.setNomeCliente(rs.getString("nomeCliente"));
                p.setCpf(rs.getString("cpf"));
                p.setCnpj(rs.getString("cnpj"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException e) {
            throw new SQLException("Cliente com este cpf não existe!\n"
                + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
        return p;
    }
    
    public void deletarCliente(int id) throws SQLException{
        //Busca conexão do BD
        Connection con = Conexao.getConexao();
        //cria espaço de trabalho sql, é a área no Java onde 
        //vamos executar os scripts SQL
        Statement stat = con.createStatement();
        
        try {
            String sql;
            sql = "delete from cliente where idCliente = " + id;
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar Cliente. \n"
                + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }
    
    public void atualizarCliente (Cliente pVO) throws SQLException{
        //Busca conexão do BD
        Connection con = Conexao.getConexao();
        //cria espaço de trabalho sql, é a área no Java onde 
        //vamos executar os scripts SQL
        Statement stat = con.createStatement();
        
        try {
            String sql;
            sql = "update cliente set "
                    + "nomeCliente = '" + pVO.getNomeCliente() + "', "
                    + "cpf = '" + pVO.getCpf() + "', "
                    + "cnpj = '" + pVO.getCnpj()+ "', "
                    + "endereco = '" + pVO.getEndereco() + "', "
                    + "telefone = '" + pVO.getTelefone() + "', "
                    + "where idCliente = " + pVO.getIdCliente();
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar Cliente. \n"
                +e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }
}
