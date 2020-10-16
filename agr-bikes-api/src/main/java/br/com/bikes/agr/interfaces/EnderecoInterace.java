package br.com.bikes.agr.interfaces;

import java.util.List;

import br.com.bikes.agr.entidade.Endereco;

public interface EnderecoInterace {

	List<Endereco> getEnderecosLista();
	List<Endereco> getEnderecosByIdLista(int id);
	List<Endereco> getEnderecosByIdClienteLista(int id);
	int insertEndereco(Endereco cliente);
	int updateEndereco(int id, Endereco cliente);
	int deleteEndereco(int id);	
	
}
