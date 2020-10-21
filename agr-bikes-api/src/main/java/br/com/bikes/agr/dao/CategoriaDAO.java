package br.com.bikes.agr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bikes.agr.config.ConnectionPool;
import br.com.bikes.agr.entidade.Categoria;
import br.com.bikes.agr.interfaces.CategoriaInterface;

public class CategoriaDAO extends ConnectionPool implements CategoriaInterface {

	private final String sqlSelectCategorias = "select id_categoria, descricao from categoria";
	private final String sqlSelectCategoriasById = "select id_categoria, descricao from categoria where id_categoria = ?";	
	private final String sqlInsertCategoria = "insert into categoria (descricao) values (?)";
	private final String sqlUpdateCategoria = "update categoria set descricao = ? where id_categoria = ?";
	private final String sqlDeleteCategoria = "delete from categoria where id_categoria = ?";
	
	@Override
	public List<Categoria> getCategoriasLista() {
		
		List<Categoria> lista = new ArrayList<>();
		ResultSet rst = this.getCategorias();	
		
		try {
			while(rst.next()) {
								
				var bean = new Categoria();
				bean.setId(rst.getInt("id_categoria"));
				bean.setDescricao(rst.getString("descricao"));				
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getCategoriasLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getCategoriasLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public List<Categoria> getCategoriasByIdLista(int id) {
		
		List<Categoria> lista = new ArrayList<>();		
		ResultSet rst = this.getCategoriasById(String.valueOf(id));		
		try {
			while(rst.next()) {
								
				var bean = new Categoria();
				bean.setId(rst.getInt("id_categoria"));
				bean.setDescricao(rst.getString("descricao"));	
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getCategoriasByIdLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getCategoriasLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public int insertCategoria(Categoria categoria) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlInsertCategoria);
			pstm.setString(1, categoria.getDescricao());						
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no insertCategoria SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no insertCategoria: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	@Override
	public int updateCategoria(int id, Categoria categoria) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlUpdateCategoria);
			pstm.setString(1, categoria.getDescricao());			
			pstm.setInt(2, id);			
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no updateCategoria SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no updateCategoria: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	@Override
	public int deleteCategoria(int id) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlDeleteCategoria);
			pstm.setInt(1, id);
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		}
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no deleteCategoria SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no deleteCategoria: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	protected ResultSet getCategorias() {
		return super.getResultSet(sqlSelectCategorias);
	}
	
	protected ResultSet getCategoriasById(String id) {
		return super.getResultSet(sqlSelectCategoriasById, id);
	}	
		
}
