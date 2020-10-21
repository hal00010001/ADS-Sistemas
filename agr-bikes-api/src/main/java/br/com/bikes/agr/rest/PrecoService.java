package br.com.bikes.agr.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.bikes.agr.dao.PrecoDAO;
import br.com.bikes.agr.entidade.Preco;

@Path("/preco")
public class PrecoService {

private PrecoDAO dao;
	
	@PostConstruct
	private void init() {
		dao = new PrecoDAO();
	}
	
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Preco> listarPrecos(){
		
		List<Preco> lista = null;
		
		try {
			lista = dao.getPrecosLista();
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
	public List<Preco> listarPrecoByIdProduto(@PathParam("id") int id){
		
		List<Preco> lista = null;
		
		try {
			lista = dao.getPrecoByIdProdutoLista(id);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		
		return lista;
		
	}
				
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String adicionarPreco(Preco preco) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.insertPreco(preco);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());			
		}
		if(linhasAlteradas > 0) {
			msg = "Preço salvo com sucesso!";
		}
		else {
			msg = "Preço não foi salvo!";
		}		
		
		return msg;
		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String atualizarPreco(@PathParam("id") int id, Preco preco) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.updatePreco(id, preco);
		}
		catch (Exception ex) {
			msg = "Erro ao atualizar o preço!";
		}
		if(linhasAlteradas > 0) {
			msg = "Preço atualizado com sucesso!";
		}
		else {
			msg = "Preço não foi atualizado!";
		}
		
		return msg;
		
	}
		
}
