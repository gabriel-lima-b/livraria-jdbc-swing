/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.ClienteDAO;
import dao.DAOFactory;
import model.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jbferraz
 */
public class ClienteServicos {

    public void cadCliente(Cliente cVO) throws SQLException {
        ClienteDAO pDAO = DAOFactory.getClienteDAO();
        pDAO.cadastrarCliente(cVO);
    }

    public ArrayList<Cliente> getClientes() throws SQLException {
        ClienteDAO pDAO = DAOFactory.getClienteDAO();
        return pDAO.listarClientes();
    }

    public boolean verCpfBD(String cpf) throws SQLException {
        ClienteDAO pDAO = DAOFactory.getClienteDAO();
        return pDAO.verCPF(cpf);
    }

    public Cliente buscarCliente(String cpf) throws SQLException {
        ClienteDAO pDAO = DAOFactory.getClienteDAO();
        return pDAO.getByDoc(cpf);
    }
    
    public void deletarClienteBD(int id) throws SQLException{
        ClienteDAO pDAO = DAOFactory.getClienteDAO();
        pDAO.deletarCliente(id);
    }
    
    public void atualizarClienteBD(Cliente pVO)throws SQLException{
        ClienteDAO pDAO = DAOFactory.getClienteDAO();
        pDAO.atualizarCliente(pVO);
    }
}
