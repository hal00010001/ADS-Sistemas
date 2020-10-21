package br.com.bikes.agr.interfaces;

import java.util.List;

import br.com.bikes.agr.entidade.Preco;

public interface PrecoInterface {

	List<Preco> getPrecosLista();
	List<Preco> getPrecoByIdProdutoLista(int id);	
	int insertPreco(Preco categoria);
	int updatePreco(int id, Preco categoria);
		
}
