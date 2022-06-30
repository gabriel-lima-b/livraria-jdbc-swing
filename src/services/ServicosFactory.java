/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author jbferraz
 */
public class ServicosFactory {
    
    private static ClienteServicos clienteServicos = new ClienteServicos();
    
    public static ClienteServicos getPessoaServicos(){
        return clienteServicos;
    }
    
}
