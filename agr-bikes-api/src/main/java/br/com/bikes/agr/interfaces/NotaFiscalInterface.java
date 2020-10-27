package br.com.bikes.agr.interfaces;

import java.util.List;

import br.com.bikes.agr.entidade.NotaFiscal;

public interface NotaFiscalInterface {

	List<NotaFiscal> getNotasFiscaisLista();
	List<NotaFiscal> getNotaFiscalByIdLista(int id);
	List<NotaFiscal> getNotaFiscalByNumeroPedidoLista(int numPedido);	
	List<NotaFiscal> getNotaFiscalByIdClienteLista(int numPedido);
	List<NotaFiscal> getNotaFiscalByNumeroNotaLista(int numPedido);
	int insertNotaFiscal(NotaFiscal notaFiscal);
	int updateNotaFiscal(int id, NotaFiscal notaFiscal);
	int deleteNotaFiscal(int id);
	
}
