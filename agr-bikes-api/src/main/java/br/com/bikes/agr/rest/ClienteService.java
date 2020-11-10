package br.com.bikes.agr.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.bikes.agr.dao.ClienteDAO;
import br.com.bikes.agr.entidade.Cliente;

@Path("/cliente")
public class ClienteService {

	private ClienteDAO dao;
	
	@PostConstruct
	private void init() {
		dao = new ClienteDAO();
	}
	
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> listarClientes(){
		
		List<Cliente> lista = null;
		
		try {
			lista = dao.getClientesLista();
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		
		return lista;
		
	}
	
	@GET
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> listarClientesById(@PathParam("id") int id){
		
		List<Cliente> lista = null;
		
		try {
			lista = dao.getClientesByIdLista(id);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		
		return lista;
		
	}
			
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String adicionarCliente(Cliente cliente) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.insertCliente(cliente);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}
		if(linhasAlteradas > 0) {
			msg = "Cliente salvo com sucesso!";
		}
		else {
			msg = "Cliente não foi salvo!";
		}
				
		return msg;
		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String atualizarCliente(@PathParam("id") int id, Cliente cliente) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.updateCliente(id, cliente);
		}
		catch (Exception ex) {
			msg = "Erro ao atualizar o cliente!";
		}
		if(linhasAlteradas > 0) {
			msg = "Cliente salvo com sucesso!";
		}
		else {
			msg = "Cliente não foi salvo!";
		}
		
		return msg;
		
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String removerCliente(@PathParam("id") int id) {
		
		String msg = "";
		
		try {
			dao.deleteCliente(id);
		}
		catch (Exception ex) {
			msg = "Erro ao remover o cliente!";
		}
		msg = "Cliente removido com sucesso!";
		
		return msg;
		
	}
	
}
