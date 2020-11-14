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

import br.com.bikes.agr.dao.EstoqueDAO;
import br.com.bikes.agr.entidade.Estoque;

@Path("/estoque")
public class EstoqueService {

	private EstoqueDAO dao;
	
	@PostConstruct
	private void init() {
		dao = new EstoqueDAO();
	}
	
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estoque> listarEstoque(){
		
		List<Estoque> lista = null;
		
		try {
			lista = dao.getEstoqueLista();
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
	public List<Estoque> listarEstoqueByIdProduto(@PathParam("id") int id){
		
		List<Estoque> lista = null;
		
		try {
			lista = dao.getEstoqueByIdProdutoLista(id);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		
		return lista;
		
	}
				
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String adicionarEstoque(Estoque estoque) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		System.out.println("Id: " + estoque.getIdProduto());
		if (dao.getEstoqueByIdProdutoLista(estoque.getIdProduto()).isEmpty()) {
			try {
				linhasAlteradas = dao.insertEstoque(estoque);
			}
			catch (Exception ex) {
				System.out.println("Erro: " + ex.getMessage());			
			}
			if(linhasAlteradas > 0) {
				msg = "Estoque salvo com sucesso!";
			}
			else {
				msg = "Estoque não foi salvo!";
			}
		}
		else {
			msg = "Produto já adicionado ao estoque";
		}		
		return msg;
		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String atualizarEstoque(@PathParam("id") int id, Estoque estoque) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.updateEstoque(id, estoque);
		}
		catch (Exception ex) {
			msg = "Erro ao atualizar o estoque!";
		}
		if(linhasAlteradas > 0) {
			msg = "Estoque atualizado com sucesso!";
		}
		else {
			msg = "Estoque não foi atualizado!";
		}
		
		return msg;
		
	}
		
}
