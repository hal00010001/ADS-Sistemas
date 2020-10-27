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

import br.com.bikes.agr.dao.NotaFiscalDAO;
import br.com.bikes.agr.entidade.NotaFiscal;

@Path("/nota-fiscal")
public class NotaFiscalService {

	private NotaFiscalDAO dao;
	
	@PostConstruct
	private void init() {
		dao = new NotaFiscalDAO();
	}
	
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public List<NotaFiscal> listarNotasFiscais(){
		
		List<NotaFiscal> lista = null;
		
		try {
			lista = dao.getNotasFiscaisLista();
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
	public List<NotaFiscal> listarNotaFiscalById(@PathParam("id") int id){
		
		List<NotaFiscal> lista = null;
		
		try {
			lista = dao.getNotaFiscalByIdLista(id);
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
	public List<NotaFiscal> listarNotaFiscalByIdCliente(@PathParam("id") int id){
		
		List<NotaFiscal> lista = null;
		
		try {
			lista = dao.getNotaFiscalByIdClienteLista(id);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		
		return lista;
		
	}
	
	@GET
	@Path("/numero-nota/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<NotaFiscal> listarNotaFiscalByNumeroNota(@PathParam("id") int id){
		
		List<NotaFiscal> lista = null;
		
		try {
			lista = dao.getNotaFiscalByNumeroNotaLista(id);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		
		return lista;
		
	}
	
	@GET
	@Path("/numero-pedido/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<NotaFiscal> listarNotaFiscalByNumeroPedido(@PathParam("id") int id){
		
		List<NotaFiscal> lista = null;
		
		try {
			lista = dao.getNotaFiscalByNumeroPedidoLista(id);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		
		return lista;
		
	}
				
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String adicionarCategoria(NotaFiscal notaFiscal) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.insertNotaFiscal(notaFiscal);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());			
		}
		if(linhasAlteradas > 0) {
			msg = "Nota fiscal salva com sucesso!";
		}
		else {
			msg = "Nota fiscal não foi salva!";
		}		
		
		return msg;
		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String atualizarCategoria(@PathParam("id") int id, NotaFiscal notaFiscal) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.updateNotaFiscal(id, notaFiscal);
		}
		catch (Exception ex) {
			msg = "Erro ao atualizar a nota fiscal!";
		}
		if(linhasAlteradas > 0) {
			msg = "Nota fiscal atualizada com sucesso!";
		}
		else {
			msg = "Nota fiscal não foi atualizada!";
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
			linhasAlteradas = dao.deleteNotaFiscal(id);
		}
		catch (Exception ex) {
			msg = "Erro ao remover a categoria!";
		}
		if(linhasAlteradas > 0) {
			msg = "Nota fiscal removida com sucesso!";
		}
		else {
			msg = "Nota fiscal não foi removida!";
		}
		
		return msg;
		
	}
	
}
