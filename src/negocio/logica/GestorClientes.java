/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.logica;

import datos.DAO.ClienteDAO;
import negocio.entidades.Cliente;

/**
 *
 * @author Rubén
 */
public class GestorClientes extends GestorGlobal
{
    private ClienteDAO clienteDAO;

    public GestorClientes()
    {
        this.clienteDAO = new ClienteDAO();
    }
    
    public Cliente getClientePorID(int idCliente)
    {
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setId(idCliente);
        
        return clienteDAO.buscarClientePorID(nuevoCliente);
    }
}
