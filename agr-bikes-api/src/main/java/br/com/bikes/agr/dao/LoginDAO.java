package br.com.bikes.agr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bikes.agr.config.ConnectionPool;
import br.com.bikes.agr.entidade.Login;
import br.com.bikes.agr.interfaces.LoginInterface;

public class LoginDAO extends ConnectionPool implements LoginInterface {

	private final String sqlSelectLogin = "select id_login, usuario, senha, status from login where status = 1";
	private final String sqlSelectLoginByUsuarioSenha = "select id_login, usuario, senha from login where usuario = ? and senha = ? and status = 1";
	private final String sqlSelectPermissoes = "select prm.id_login as idLogin, prm.id_grupo, log.usuario, grp.nome, grp.descricao from permissao as prm, login as log, grupo as grp where log.id_login = prm.id_login and grp.id_grupo = prm.id_grupo and prm.id_login = ?";
	
	private final String sqlInsertLogin = "insert into login (usuario, senha, status) values (?, ?, 1)";
	private final String sqlInsertGrupo = "insert into grupo (nome, descricao) values (?, ?)";
	private final String sqlInsertPermissao = "insert into permissao (id_login, id_grupo) values (?, ?)";
	
	private final String sqlUpdateLogin = "update login set usuario = ? where id_login = ?";
	private final String sqlUpdatePassword = "update login set senha = ? where id_login = ?";
	private final String sqlUpdateGrupo = "update grupo set nome = ?, descricao = ? where id_grupo = ?";
	
	private final String sqlDeleteLogin = "update login set status = 0 where id_login = ?";
	private final String sqlDeleteGrupo = "delete from grupo where id_grupo = ?";
	private final String sqlDeletePermissao = "delete from permissao where id_permissao = ?";
	
	@Override
	public List<Login> getLogin() {
		
		List<Login> lista = new ArrayList<>();		
		ResultSet rst = this.getSelectLogin();		
		try {
			while(rst.next()) {
				var bean = new Login();
				bean.setId(rst.getInt("id_login"));
				bean.setUsuario(rst.getString("usuario"));
				bean.setSenha(rst.getString("senha"));
				bean.setStatus(rst.getInt("status"));
				lista.add(bean);
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getLogin SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getLogin: " + ex.getMessage());
        }		
		return lista;
		
	}


	@Override
	public boolean getLoginFromUsuarioSenha(Login login) {
				
		boolean resultado = false;
		ResultSet rst = this.getLoginByUsuarioSenha(login.getUsuario(), login.getSenha());		
		try {
			if(rst.next()) {
				resultado = true;				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getLoginFromUsuarioSenha SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getLoginFromUsuarioSenha: " + ex.getMessage());
        }
		return resultado;
		
	}
	
	@Override
	public List<Login> getPermissoesLista(int id) {
		
		List<Login> lista = new ArrayList<>();		
		ResultSet rst = this.getPermissoes(String.valueOf(id));		
		try {
			while(rst.next()) {
				var bean = new Login();
				bean.setId(rst.getInt("idLogin"));
				bean.setUsuario(rst.getString("usuario"));
				bean.setIdGrupo(rst.getInt("id_grupo"));
				bean.setNomeGrupo(rst.getString("nome"));
				bean.setDescricaoGrupo(rst.getString("descricao"));
				lista.add(bean);
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getPermissoesLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getPermissoesLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public int insertLogin(Login login) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlInsertLogin);
			pstm.setString(1, login.getUsuario());
			pstm.setString(2, login.getSenha());						
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no insertLogin SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no insertLogin: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}
	
	@Override
	public int insertGrupo(Login login) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlInsertGrupo);
			pstm.setString(1, login.getNomeGrupo());
			pstm.setString(2, login.getDescricaoGrupo());					
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no insertGrupo SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no insertGrupo: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}
	
	@Override
	public int insertPermissao(Login login) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlInsertPermissao);
			pstm.setInt(1, login.getId());
			pstm.setInt(2, login.getIdGrupo());					
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no insertPermissao SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no insertPermissao: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	@Override
	public int updateLogin(int id, Login login) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlUpdateLogin);
			pstm.setString(1, login.getUsuario());			
			pstm.setInt(2, id);
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no updateLogin SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no updateLogin: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}
	
	@Override
	public int updatePassword(int id, Login login) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlUpdatePassword);
			pstm.setString(1, login.getSenha());
			pstm.setInt(2, id);
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no updatePassword SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no updatePasswword: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}	

	@Override
	public int updateGrupo(int id, Login login) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlUpdateGrupo);
			pstm.setString(1, login.getNomeGrupo());
			pstm.setString(2, login.getDescricaoGrupo());			
			pstm.setInt(3, id);
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no updateGrupo SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no updateGrupo: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	@Override
	public int deleteLogin(int id) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlDeleteLogin);
			pstm.setInt(1, id);
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		}
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no deleteLogin SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no deleteLogin: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	@Override
	public int deleteGrupo(int id) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlDeleteGrupo);
			pstm.setInt(1, id);
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		}
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no deleteGrupo SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no deleteGrupo: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	@Override
	public int deletePermissao(int id) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlDeletePermissao);
			pstm.setInt(1, id);
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		}
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no deletePermissao SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no deletePermissao: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}
	
	protected ResultSet getSelectLogin() {
		return super.getResultSet(sqlSelectLogin);
	}
	
	protected ResultSet getLoginByUsuarioSenha(String usuario, String senha) {
		return super.getResultSet(sqlSelectLoginByUsuarioSenha, usuario, senha);
	}
	
	protected ResultSet getPermissoes(String id) {
		return super.getResultSet(sqlSelectPermissoes, id);
	}
	
}
