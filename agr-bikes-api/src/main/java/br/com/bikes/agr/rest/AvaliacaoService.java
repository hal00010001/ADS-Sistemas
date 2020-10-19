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

import br.com.bikes.agr.dao.AvaliacaoDAO;
import br.com.bikes.agr.entidade.Avaliacao;

@Path("/avaliacao")
public class AvaliacaoService {

	private AvaliacaoDAO dao;
	
	@PostConstruct
	private void init() {
		dao = new AvaliacaoDAO();
	}
	
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Avaliacao> listarAvaliacoes(){
		
		List<Avaliacao> lista = null;
		
		try {
			lista = dao.getAvaliacoesLista();
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
	public List<Avaliacao> listarAvaliacoesById(@PathParam("id") int id){
		
		List<Avaliacao> lista = null;
		
		try {
			lista = dao.getAvaliacoesByIdLista(id);
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
	public List<Avaliacao> listarAvaliacoesByIdCliente(@PathParam("id") int id){
		
		List<Avaliacao> lista = null;
		
		try {
			lista = dao.getAvaliacoesByIdClienteLista(id);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		
		return lista;
		
	}
			
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String adicionarAvaliacao(Avaliacao avaliacao) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.insertAvaliacao(avaliacao);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());			
		}
		if(linhasAlteradas > 0) {
			msg = "Avaliação salva com sucesso!";
		}
		else {
			msg = "Avaliação não foi salva!";
		}		
		
		return msg;
		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String atualizarAvaliacao(@PathParam("id") int id, Avaliacao avaliacao) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.updateAvaliacao(id, avaliacao);
		}
		catch (Exception ex) {
			msg = "Erro ao atualizar a avaliação!";
		}
		if(linhasAlteradas > 0) {
			msg = "Avaliação atualizada com sucesso!";
		}
		else {
			msg = "Avaliação não foi atualizada!";
		}
		
		return msg;
		
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String removerAvaliacao(@PathParam("id") int id) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.deleteAvaliacao(id);
		}
		catch (Exception ex) {
			msg = "Erro ao remover a avaliação!";
		}
		if(linhasAlteradas > 0) {
			msg = "Avaliação removida com sucesso!";
		}
		else {
			msg = "Avaliação não foi removida!";
		}
		
		return msg;
		
	}
	
}
