package br.com.bikes.agr.interfaces;

import java.util.List;

import br.com.bikes.agr.entidade.Produto;

public interface ProdutoInterface {

	List<Produto> getProdutosLista();
	List<Produto> getProdutosByIdLista(int id);
	List<Produto> getProdutosByIdCategoriaLista(int id);
	int insertProduto(Produto produto);
	int updateProduto(int id, Produto produto);
	int deleteProduto(int id);
	
}
