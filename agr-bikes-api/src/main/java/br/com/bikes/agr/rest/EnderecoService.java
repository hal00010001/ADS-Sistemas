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

import br.com.bikes.agr.dao.EnderecoDAO;
import br.com.bikes.agr.entidade.Endereco;

@Path("/endereco")
public class EnderecoService {

	private EnderecoDAO dao;
	
	@PostConstruct
	private void init() {
		dao = new EnderecoDAO();
	}
	
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Endereco> listarEnderecos(){
		
		List<Endereco> lista = null;
		
		try {
			lista = dao.getEnderecosLista();
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
	public List<Endereco> listarEnderecosById(@PathParam("id") int id){
		
		List<Endereco> lista = null;
		
		try {
			lista = dao.getEnderecosByIdLista(id);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		
		return lista;
		
	}
	
	@GET
	@Path("/cliente/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Endereco> listarEnderecosByIdCliente(@PathParam("id") int id){
		
		List<Endereco> lista = null;
		
		try {
			lista = dao.getEnderecosByIdClienteLista(id);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		
		return lista;
		
	}
			
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String adicionarEndereco(Endereco endereco) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.insertEndereco(endereco);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());			
		}
		if(linhasAlteradas > 0) {
			msg = "Endereco salvo com sucesso!";
		}
		else {
			msg = "Endereco não foi salvo!";
		}		
		
		return msg;
		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String atualizarEndereco(@PathParam("id") int id, Endereco endereco) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			dao.updateEndereco(id, endereco);
		}
		catch (Exception ex) {
			msg = "Erro ao atualizar o cliente!";
		}
		if(linhasAlteradas > 0) {
			msg = "Endereco atualizado com sucesso!";
		}
		else {
			msg = "Endereco não foi atualizado!";
		}
		
		return msg;
		
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String removerCliente(@PathParam("id") int id) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.deleteEndereco(id);
		}
		catch (Exception ex) {
			msg = "Erro ao remover o endereco!";
		}
		if(linhasAlteradas > 0) {
			msg = "Endereco removido com sucesso!";
		}
		else {
			msg = "Endereco não foi removido!";
		}
		
		return msg;
		
	}
	
}
