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

import br.com.bikes.agr.dao.ProdutoDAO;
import br.com.bikes.agr.entidade.Produto;

@Path("/produto")
public class ProdutoService {

	private ProdutoDAO dao;
	
	@PostConstruct
	private void init() {
		dao = new ProdutoDAO();
	}
	
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> listarProdutos(){
		
		List<Produto> lista = null;
		
		try {
			lista = dao.getProdutosLista();
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
	public List<Produto> listarProdutosById(@PathParam("id") int id){
		
		List<Produto> lista = null;
		
		try {
			lista = dao.getProdutosByIdLista(id);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		
		return lista;
		
	}
	
	@GET
	@Path("/categoria/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> listarProdutosByIdCliente(@PathParam("id") int id){
		
		List<Produto> lista = null;
		
		try {
			lista = dao.getProdutosByIdCategoriaLista(id);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		
		return lista;
		
	}
			
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String adicionarProduto(Produto produto) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.insertProduto(produto);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());			
		}
		if(linhasAlteradas > 0) {
			msg = "Produto salvo com sucesso!";
		}
		else {
			msg = "Produto não foi salvo!";
		}		
		
		return msg;
		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String atualizarProduto(@PathParam("id") int id, Produto produto) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.updateProduto(id, produto);
		}
		catch (Exception ex) {
			msg = "Erro ao atualizar o produto!";
		}
		if(linhasAlteradas > 0) {
			msg = "Produto atualizado com sucesso!";
		}
		else {
			msg = "Produto não foi atualizado!";
		}
		
		return msg;
		
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String removerProduto(@PathParam("id") int id) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.deleteProduto(id);
		}
		catch (Exception ex) {
			msg = "Erro ao remover o produto!";
		}
		if(linhasAlteradas > 0) {
			msg = "Produto removido com sucesso!";
		}
		else {
			msg = "Produto não foi removido!";
		}
		
		return msg;
		
	}
	
}
