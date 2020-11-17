package br.com.bikes.agr.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.bikes.agr.dao.RelatorioDAO;
import br.com.bikes.agr.entidade.NotaFiscal;
import br.com.bikes.agr.entidade.Relatorio;

@Path("/relatorio")
public class RelatorioService {

	private RelatorioDAO dao;
	
	@PostConstruct
	private void init() {
		dao = new RelatorioDAO();
	}
	
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Relatorio> listarMaisVendidos(){
		
		List<Relatorio> lista = null;
		
		try {
			lista = dao.getMaisVendidosLista();
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
	public List<NotaFiscal> listarVendasMensais(@PathParam ("id") String id){
		
		List<NotaFiscal> lista = null;
		
		String dataInicio = null;
		String dataTermino = null;
				
		dataInicio = id.substring(0, 8);
		dataTermino = id.substring(8, 16);
		
		int dataTerminoInt = Integer.parseInt(dataTermino) + 1;
		
		dataTermino = String.valueOf(dataTerminoInt);		
		
		dataInicio = dataInicio.substring(0, 2) + "/" + dataInicio.substring(2, 4) + "/" + dataInicio.substring(4, 8);
		dataTermino = dataTermino.substring(0, 2) + "/" + dataTermino.substring(2, 4) + "/" + dataTermino.substring(4, 8);
		
		System.out.println("Início: " + dataInicio + " Término: " + dataTermino);
		
		try {
			lista = dao.getVendasMensaisLista(dataInicio, dataTermino);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		
		return lista;
		
	}
	
}
