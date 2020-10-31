package br.com.bikes.agr.interfaces;

import java.util.List;

import br.com.bikes.agr.entidade.Login;

public interface LoginInterface {

	List<Login> getLogin();
	boolean getLoginFromUsuarioSenha(Login login);
	List<Login> getPermissoesLista(int id);
	int insertLogin(Login login);
	int insertGrupo(Login login);
	int insertPermissao(Login login);
	int updateLogin(int id, Login login);
	int updatePassword(int id, Login login);	
	int updateGrupo(int id, Login login);
	int deleteLogin(int id);
	int deleteGrupo(int id);
	int deletePermissao(int id);
	
}
