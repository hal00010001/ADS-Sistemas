package br.com.bikes.agr.interfaces;

import java.util.List;

import br.com.bikes.agr.entidade.Estoque;

public interface EstoqueInterface {

	List<Estoque> getEstoqueLista();	
	List<Estoque> getEstoqueByIdProdutoLista(int id);
	int insertEstoque(Estoque estoque);
	int updateEstoque(int id, Estoque estoque);
		
}
