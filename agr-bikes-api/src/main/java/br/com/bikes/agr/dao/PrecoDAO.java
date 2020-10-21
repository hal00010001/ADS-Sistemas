package br.com.bikes.agr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bikes.agr.config.ConnectionPool;
import br.com.bikes.agr.entidade.Preco;
import br.com.bikes.agr.interfaces.PrecoInterface;

public class PrecoDAO extends ConnectionPool implements PrecoInterface {

	private final String sqlSelectPrecos = "select id_preco, prc.id_produto, valor, pdt.descricao as nome_produto from preco as prc, produto as pdt where prc.id_produto = pdt.id_produto";
	private final String sqlSelectPrecosByIdProduto = "select id_preco, prc.id_produto, valor, pdt.descricao as nome_produto from preco as prc, produto as pdt where prc.id_produto = pdt.id_produto and prc.id_produto = ?";	
	private final String sqlInsertPreco = "insert into preco (id_produto, valor) values (?, ?)";
	private final String sqlUpdatePreco = "update preco set valor = ? where id_produto = ?";
		
	@Override
	public List<Preco> getPrecosLista() {
		
		List<Preco> lista = new ArrayList<>();
		ResultSet rst = this.getPrecos();	
		
		try {
			while(rst.next()) {
								
				var bean = new Preco();
				bean.setId(rst.getInt("id_preco"));
				bean.setIdProduto(rst.getInt("id_produto"));
				bean.setValor(rst.getDouble("valor"));
				bean.setNomeProduto(rst.getString("nome_produto"));
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getPrecosLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getPrecosLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public List<Preco> getPrecoByIdProdutoLista(int id) {
		
		List<Preco> lista = new ArrayList<>();		
		ResultSet rst = this.getPrecosByIdProduto(String.valueOf(id));		
		try {
			while(rst.next()) {
								
				var bean = new Preco();
				bean.setId(rst.getInt("id_preco"));
				bean.setIdProduto(rst.getInt("id_produto"));
				bean.setValor(rst.getDouble("valor"));
				bean.setNomeProduto(rst.getString("nome_produto"));
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getPrecosByIdLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getPrecosLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public int insertPreco(Preco preco) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlInsertPreco);
			pstm.setInt(1, preco.getIdProduto());
			pstm.setDouble(2, preco.getValor());
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no insertPreco SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no insertPreco: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	@Override
	public int updatePreco(int id, Preco preco) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlUpdatePreco);
			pstm.setDouble(1, preco.getValor());			
			pstm.setInt(2, id);			
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no updatePreco SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no updatePreco: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	protected ResultSet getPrecos() {
		return super.getResultSet(sqlSelectPrecos);
	}
	
	protected ResultSet getPrecosByIdProduto(String id) {
		return super.getResultSet(sqlSelectPrecosByIdProduto, id);
	}
	
}
