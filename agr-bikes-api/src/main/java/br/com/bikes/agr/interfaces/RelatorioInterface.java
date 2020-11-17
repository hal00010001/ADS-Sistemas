package br.com.bikes.agr.interfaces;

import java.util.List;

import br.com.bikes.agr.entidade.NotaFiscal;
import br.com.bikes.agr.entidade.Relatorio;

public interface RelatorioInterface {

	List<Relatorio> getMaisVendidosLista();
	List<NotaFiscal> getVendasMensaisLista(String dataInicio, String dataTermino);
	
}
