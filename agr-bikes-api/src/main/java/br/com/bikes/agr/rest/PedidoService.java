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

import br.com.bikes.agr.dao.PedidoDAO;
import br.com.bikes.agr.entidade.Pedido;

@Path("/pedido")
public class PedidoService {

	private PedidoDAO dao;
	
	@PostConstruct
	private void init() {
		dao = new PedidoDAO();
	}
	
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pedido> listarPedidos(){
		
		List<Pedido> lista = null;
		
		try {
			lista = dao.getPedidosLista();
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		
		return lista;
		
	}
	
	@GET
	@Path("/recente")
	@Produces(MediaType.APPLICATION_JSON)
	public int listarPedidoRecente(){
		
		int resultado = 0;
		
		try {
			resultado = dao.getPedidoRecenteLista();
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		
		return resultado;
		
	}
	
	@GET
	@Path("/produto/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pedido> listarPedidosByIdProduto(@PathParam("id") int id ){
		
		List<Pedido> lista = null;
		
		try {
			lista = dao.getPedidosByIdProdutoLista(id);
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
	public List<Pedido> listarPedidosByIdCliente(@PathParam("id") int id ){
		
		List<Pedido> lista = null;
		
		try {
			lista = dao.getPedidosByIdClienteLista(id);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		
		return lista;
		
	}
	
	@GET
	@Path("/cliente-recente/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public int listarPedidosByIdClienteRecente(@PathParam("id") int id ){
		
		int resultado = 0;
		
		try {
			resultado = dao.getPedidosByIdClienteRecenteLista(id);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		
		return resultado;
		
	}	
	
	@GET
	@Path("/numero-pedido/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pedido> listarPedidoByNumeroPedido(@PathParam("id") int numPedido ){
		
		List<Pedido> lista = null;
		
		try {
			lista = dao.getPedidoByNumeroPedido(numPedido);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}
		
		return lista;
		
	} 
				
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String adicionarPedido(Pedido pedido) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.insertPedido(pedido);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());			
		}
		if(linhasAlteradas > 0) {
			msg = "Pedido salvo com sucesso!";
		}
		else {
			msg = "Pedido não foi salvo!";
		}		
		
		return msg;
		
	}
	
	@PUT	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String fecharPedido(Pedido pedido) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.updatePedido(pedido.getNumeroPedido());
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());			
		}
		if(linhasAlteradas > 0) {
			msg = "Pedido finalizado com sucesso!";
		}
		else {
			msg = "Pedido não foi finalizado!";
		}		
		
		return msg;
		
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String removerPedido(@PathParam("id") int id) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.deletePedido(id);
		}
		catch (Exception ex) {
			msg = "Erro ao remover o pedido!";
		}
		if(linhasAlteradas > 0) {
			msg = "Pedido removido com sucesso!";
		}
		else {
			msg = "Pedido não foi removido!";
		}
		
		return msg;
		
	}
	
}
