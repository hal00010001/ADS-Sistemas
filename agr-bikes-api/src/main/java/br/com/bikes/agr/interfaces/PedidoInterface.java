package br.com.bikes.agr.interfaces;

import java.util.List;

import br.com.bikes.agr.entidade.Pedido;

public interface PedidoInterface {

	List<Pedido> getPedidosLista();
	int getPedidoRecenteLista();
	int getPedidoRecenteNovoLista();
	List<Pedido> getPedidosByIdProdutoLista(int id);
	List<Pedido> getPedidosByIdClienteLista(int id);
	List<Pedido> getPedidoByNumeroPedido(int numPedido);
	double getPedidoSomaByNumeroPedido(int numPedido);
	int getPedidosByIdClienteRecenteLista(int id);	
	int insertPedido(Pedido pedido);
	int updatePedido(int numeroPedido);
	int deletePedido(int id);
	
}
