package br.com.bikes.agr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bikes.agr.config.ConnectionPool;
import br.com.bikes.agr.entidade.Estoque;
import br.com.bikes.agr.interfaces.EstoqueInterface;

public class EstoqueDAO extends ConnectionPool implements EstoqueInterface {

	private final String sqlSelectEstoque = "select id_estoque, est.id_produto as idProduto, pdt.descricao, quantidade from estoque as est, produto as pdt where est.id_produto = pdt.id_produto";
	private final String sqlSelectEstoqueByIdProduto = "select id_estoque, est.id_produto as idProduto, pdt.descricao, quantidade from estoque as est, produto as pdt where est.id_produto = pdt.id_produto and pdt.id_produto = ?";
	private final String sqlInsertEstoque = "insert into estoque (id_produto, quantidade) values (?, 0)";
	private final String sqlUpdateEstoque = "update estoque set quantidade = ? where id_produto = ?";
			
	@Override
	public List<Estoque> getEstoqueLista() {
		
		List<Estoque> lista = new ArrayList<>();
		ResultSet rst = this.getEstoque();	
		
		try {
			while(rst.next()) {
								
				var bean = new Estoque();
				bean.setId(rst.getInt("id_estoque"));
				bean.setIdProduto(rst.getInt("idProduto"));
				bean.setNomeProduto(rst.getString("descricao"));
				bean.setQuantidade(rst.getInt("quantidade"));
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getEstoqueLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getEstoqueLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public List<Estoque> getEstoqueByIdProdutoLista(int id) {
		
		List<Estoque> lista = new ArrayList<>();		
		ResultSet rst = this.getEstoqueByIdProduto(String.valueOf(id));		
		try {
			while(rst.next()) {
								
				var bean = new Estoque();
				bean.setId(rst.getInt("id_estoque"));
				bean.setIdProduto(rst.getInt("idProduto"));
				bean.setNomeProduto(rst.getString("descricao"));
				bean.setQuantidade(rst.getInt("quantidade"));	
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getEstoqueByIdLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getEstoqueLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public int insertEstoque(Estoque estoque) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlInsertEstoque);
			pstm.setInt(1, estoque.getIdProduto());						
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no insertEstoque SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no insertEstoque: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	@Override
	public int updateEstoque(int id, Estoque estoque) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlUpdateEstoque);
			pstm.setInt(1, estoque.getQuantidade());			
			pstm.setInt(2, id);			
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no updateEstoque SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no updateEstoque: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	protected ResultSet getEstoque() {
		return super.getResultSet(sqlSelectEstoque);
	}
	
	protected ResultSet getEstoqueByIdProduto(String id) {
		return super.getResultSet(sqlSelectEstoqueByIdProduto, id);
	}
	
}
