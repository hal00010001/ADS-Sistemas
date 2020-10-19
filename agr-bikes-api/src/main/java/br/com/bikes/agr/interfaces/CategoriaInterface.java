package br.com.bikes.agr.interfaces;

import java.util.List;

import br.com.bikes.agr.entidade.Categoria;

public interface CategoriaInterface {

	List<Categoria> getCategoriasLista();
	List<Categoria> getCategoriasByIdLista(int id);	
	int insertCategoria(Categoria categoria);
	int updateCategoria(int id, Categoria categoria);
	int deleteCategoria(int id);
		
}
