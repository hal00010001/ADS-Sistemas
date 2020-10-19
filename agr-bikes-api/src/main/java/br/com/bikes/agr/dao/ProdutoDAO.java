package br.com.bikes.agr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bikes.agr.config.ConnectionPool;
import br.com.bikes.agr.entidade.Produto;
import br.com.bikes.agr.interfaces.ProdutoInterface;

public class ProdutoDAO extends ConnectionPool implements ProdutoInterface {

	private final String sqlSelectProdutos = "select pdt.id_produto, pdt.descricao, pdt.id_categoria, ctg.descricao as cat_desc from produto as pdt, categoria as ctg where pdt.id_categoria = ctg.id_categoria";
	private final String sqlSelectProdutosById = "select pdt.id_produto, pdt.descricao, pdt.id_categoria, ctg.descricao as cat_desc from produto as pdt, categoria as ctg where pdt.id_categoria = ctg.id_categoria and pdt.id_produto = ?";
	private final String sqlSelectProdutosByIdCategoria = "select pdt.id_produto, pdt.descricao, pdt.id_categoria, ctg.descricao as cat_desc from produto as pdt, categoria as ctg where pdt.id_categoria = ctg.id_categoria and pdt.id_categoria = ?";
	private final String sqlInsertProduto = "insert into produto (descricao, id_categoria) values (?, ?)";
	private final String sqlUpdateProduto = "update produto set descricao = ?, id_categoria = ? where id_produto = ?";
	private final String sqlDeleteProduto = "delete from produto where id_produto = ?";
	
	@Override
	public List<Produto> getProdutosLista() {
		
		List<Produto> lista = new ArrayList<>();
		ResultSet rst = this.getProdutos();	
		
		try {
			while(rst.next()) {
								
				var bean = new Produto();
				bean.setId(rst.getInt("id_produto"));
				bean.setDescricao(rst.getString("descricao"));
				bean.setIdCategoria(rst.getInt("id_categoria"));
				bean.setNomeCategoria(rst.getString("cat_desc"));
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getProdutosLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getProdutosLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public List<Produto> getProdutosByIdLista(int id) {
		
		List<Produto> lista = new ArrayList<>();		
		ResultSet rst = this.getProdutosById(String.valueOf(id));		
		try {
			while(rst.next()) {
								
				var bean = new Produto();
				bean.setId(rst.getInt("id_produto"));
				bean.setDescricao(rst.getString("descricao"));
				bean.setIdCategoria(rst.getInt("id_categoria"));
				bean.setNomeCategoria(rst.getString("cat_desc"));
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getProdutosByIdLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getProdutosLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public List<Produto> getProdutosByIdCategoriaLista(int id) {
		
		List<Produto> lista = new ArrayList<>();		
		ResultSet rst = this.getProdutosByIdCategoria(String.valueOf(id));		
		try {
			while(rst.next()) {
								
				var bean = new Produto();
				bean.setId(rst.getInt("id_produto"));
				bean.setDescricao(rst.getString("descricao"));
				bean.setIdCategoria(rst.getInt("id_categoria"));
				bean.setNomeCategoria(rst.getString("cat_desc"));
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getProdutoByIdClienteLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getProdutoByIdClienteLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public int insertProduto(Produto produto) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlInsertProduto);
			pstm.setString(1, produto.getDescricao());
			pstm.setInt(2, produto.getIdCategoria());	
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no insertProduto SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no insertProduto: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	@Override
	public int updateProduto(int id, Produto produto) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlUpdateProduto);
			pstm.setString(1, produto.getDescricao());
			pstm.setInt(2, produto.getIdCategoria());			
			pstm.setInt(3, id);			
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no updateProduto SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no updateProduto: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	@Override
	public int deleteProduto(int id) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlDeleteProduto);
			pstm.setInt(1, id);
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		}
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no deleteProduto SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no deleteProduto: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	protected ResultSet getProdutos() {
		return super.getResultSet(sqlSelectProdutos);
	}
	
	protected ResultSet getProdutosById(String id) {
		return super.getResultSet(sqlSelectProdutosById, id);
	}	
	
	protected ResultSet getProdutosByIdCategoria(String id) {
		return super.getResultSet(sqlSelectProdutosByIdCategoria, id);
	}
	
}
