package br.com.bikes.agr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.bikes.agr.config.ConnectionPool;
import br.com.bikes.agr.entidade.Avaliacao;
import br.com.bikes.agr.interfaces.AvaliacaoInterface;

public class AvaliacaoDAO extends ConnectionPool implements AvaliacaoInterface {

	private final String sqlSelectAvaliacoes = "select id_avaliacao, comentario, nota, data_inclusao, ava.id_cliente, cli.nome as nome from avaliacao as ava, cliente as cli where ava.id_cliente = cli.id_cliente order by id_avaliacao";
	private final String sqlSelectAvaliacoesById = "select id_avaliacao, comentario, nota, data_inclusao, ava.id_cliente, cli.nome as nome from avaliacao as ava, cliente as cli where ava.id_cliente = cli.id_cliente and ava.id_avaliacao = ?";
	private final String sqlSelectAvaliacoesByIdCliente = "select id_avaliacao, comentario, nota, data_inclusao, ava.id_cliente, cli.nome as nome from avaliacao as ava, cliente as cli where ava.id_cliente = cli.id_cliente and ava.id_cliente = ?";
	private final String sqlInsertAvaliacao = "insert into avaliacao (comentario, nota, data_inclusao, id_cliente) values (?, ?, now(), ?)";
	private final String sqlUpdateAvaliacao = "update avaliacao set comentario = ?, nota = ?, data_inclusao = now(), id_cliente = ? where id_avaliacao = ?";
	private final String sqlDeleteAvaliacao = "delete from avaliacao where id_avaliacao = ?";
	
	@Override
	public List<Avaliacao> getAvaliacoesLista() {
		
		List<Avaliacao> lista = new ArrayList<>();
		ResultSet rst = this.getAvaliacoes();	
		
		try {
			while(rst.next()) {
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				
				var bean = new Avaliacao();
				bean.setId(rst.getInt("id_avaliacao"));
				bean.setComentario(rst.getString("comentario"));
				bean.setNota(rst.getDouble("nota"));
				bean.setDataInclusao(df.format(rst.getTimestamp("data_inclusao")));				
				bean.setIdCliente(rst.getInt("id_cliente"));
				bean.setNomeCliente(rst.getString("nome"));
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getAvaliacoesLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getAvaliacoesLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public List<Avaliacao> getAvaliacoesByIdLista(int id) {
		
		List<Avaliacao> lista = new ArrayList<>();		
		ResultSet rst = this.getAvaliacoesById(String.valueOf(id));		
		try {
			while(rst.next()) {
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				
				var bean = new Avaliacao();
				bean.setId(rst.getInt("id_avaliacao"));
				bean.setComentario(rst.getString("comentario"));
				bean.setNota(rst.getDouble("nota"));
				bean.setDataInclusao(df.format(rst.getTimestamp("data_inclusao")));				
				bean.setIdCliente(rst.getInt("id_cliente"));
				bean.setNomeCliente(rst.getString("nome"));
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getAvaliacoesByIdLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getAvaliacoesLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public List<Avaliacao> getAvaliacoesByIdClienteLista(int id) {
		
		List<Avaliacao> lista = new ArrayList<>();		
		ResultSet rst = this.getAvaliacoesByIdCliente(String.valueOf(id));		
		try {
			while(rst.next()) {
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				
				var bean = new Avaliacao();
				bean.setId(rst.getInt("id_avaliacao"));
				bean.setComentario(rst.getString("comentario"));
				bean.setNota(rst.getDouble("nota"));
				bean.setDataInclusao(df.format(rst.getTimestamp("data_inclusao")));				
				bean.setIdCliente(rst.getInt("id_cliente"));
				bean.setNomeCliente(rst.getString("nome"));
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getAvaliacoesByIdClienteLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getAvaliacoesByIdClienteLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public int insertAvaliacao(Avaliacao avaliacao) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlInsertAvaliacao);
			pstm.setString(1, avaliacao.getComentario());
			pstm.setDouble(2, avaliacao.getNota());
			pstm.setInt(3, avaliacao.getIdCliente());			
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no insertAvaliacao SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no insertAvaliacao: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	@Override
	public int updateAvaliacao(int id, Avaliacao avaliacao) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlUpdateAvaliacao);
			pstm.setString(1, avaliacao.getComentario());
			pstm.setDouble(2, avaliacao.getNota());
			pstm.setInt(3, avaliacao.getIdCliente());
			pstm.setInt(4, id);			
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no updateAvaliacao SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no updateAvaliacao: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	@Override
	public int deleteAvaliacao(int id) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlDeleteAvaliacao);
			pstm.setInt(1, id);
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		}
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no deleteAvaliacao SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no deleteAvaliacao: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	protected ResultSet getAvaliacoes() {
		return super.getResultSet(sqlSelectAvaliacoes);
	}
	
	protected ResultSet getAvaliacoesById(String id) {
		return super.getResultSet(sqlSelectAvaliacoesById, id);
	}	
	
	protected ResultSet getAvaliacoesByIdCliente(String id) {
		return super.getResultSet(sqlSelectAvaliacoesByIdCliente, id);
	}
	
}
