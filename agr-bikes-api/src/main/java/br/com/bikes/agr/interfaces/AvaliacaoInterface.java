package br.com.bikes.agr.interfaces;

import java.util.List;

import br.com.bikes.agr.entidade.Avaliacao;

public interface AvaliacaoInterface {

	List<Avaliacao> getAvaliacoesLista();
	List<Avaliacao> getAvaliacoesByIdLista(int id);
	List<Avaliacao> getAvaliacoesByIdClienteLista(int id);
	int insertAvaliacao(Avaliacao avaliacao);
	int updateAvaliacao(int id, Avaliacao avaliacao);
	int deleteAvaliacao(int id);
	
}
