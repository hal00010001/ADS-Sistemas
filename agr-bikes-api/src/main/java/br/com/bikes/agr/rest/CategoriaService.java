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

import br.com.bikes.agr.dao.CategoriaDAO;
import br.com.bikes.agr.entidade.Categoria;

@Path("/categoria")
public class CategoriaService {

	private CategoriaDAO dao;
	
	@PostConstruct
	private void init() {
		dao = new CategoriaDAO();
	}
	
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categoria> listarCategorias(){
		
		List<Categoria> lista = null;
		
		try {
			lista = dao.getCategoriasLista();
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
	public List<Categoria> listarAvaliacoesById(@PathParam("id") int id){
		
		List<Categoria> lista = null;
		
		try {
			lista = dao.getCategoriasByIdLista(id);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		
		return lista;
		
	}
				
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String adicionarCategoria(Categoria categoria) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.insertCategoria(categoria);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());			
		}
		if(linhasAlteradas > 0) {
			msg = "Categoria salva com sucesso!";
		}
		else {
			msg = "Categoria não foi salva!";
		}		
		
		return msg;
		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String atualizarCategoria(@PathParam("id") int id, Categoria categoria) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.updateCategoria(id, categoria);
		}
		catch (Exception ex) {
			msg = "Erro ao atualizar a categoria!";
		}
		if(linhasAlteradas > 0) {
			msg = "Categoria atualizada com sucesso!";
		}
		else {
			msg = "Categoria não foi atualizada!";
		}
		
		return msg;
		
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String removerCategoria(@PathParam("id") int id) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.deleteCategoria(id);
		}
		catch (Exception ex) {
			msg = "Erro ao remover a categoria!";
		}
		if(linhasAlteradas > 0) {
			msg = "Categoria removida com sucesso!";
		}
		else {
			msg = "Categoria não foi removida!";
		}
		
		return msg;
		
	}
	
}
