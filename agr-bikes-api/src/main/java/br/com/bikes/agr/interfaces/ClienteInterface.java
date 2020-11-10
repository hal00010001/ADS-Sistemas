package br.com.bikes.agr.interfaces;

import java.util.List;

import br.com.bikes.agr.entidade.Cliente;

public interface ClienteInterface {

	List<Cliente> getClientesLista();
	List<Cliente> getClientesByIdLista(int id);
	int insertCliente(Cliente cliente);
	int updateCliente(int id, Cliente cliente);
	int deleteCliente(int id);	
	
}
