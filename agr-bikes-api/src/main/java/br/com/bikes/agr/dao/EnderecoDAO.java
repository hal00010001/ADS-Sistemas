package br.com.bikes.agr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bikes.agr.config.ConnectionPool;
import br.com.bikes.agr.entidade.Endereco;
import br.com.bikes.agr.interfaces.EnderecoInterace;

public class EnderecoDAO extends ConnectionPool implements EnderecoInterace {

	private final String sqlSelectEnderecos = "select id_endereco, rua, numero, bairro, cep, end.id_cliente, cli.nome as nome from endereco as end, cliente as cli where end.id_cliente = cli.id_cliente";
	private final String sqlSelectEnderecosById = "select id_endereco, rua, numero, bairro, cep, end.id_cliente, cli.nome as nome from endereco as end, cliente as cli where id_endereco = ? and end.id_cliente = cli.id_cliente";
	private final String sqlSelectEnderecosByIdCliente = "select id_endereco, rua, numero, bairro, cep, end.id_cliente, cli.nome as nome from endereco as end, cliente as cli where end.id_cliente = ? and end.id_cliente = cli.id_cliente";
	private final String sqlInsertEndereco = "insert into endereco (rua, numero, bairro, cep, id_cliente) values (?, ?, ?, ?, ?)";
	private final String sqlUpdateEndereco = "update endereco set rua = ?, numero = ?, bairro = ?, cep = ?, id_cliente = ? where id_endereco = ?";
	private final String sqlDeleteEndereco = "delete from endereco where id_endereco = ?";
	
	@Override
	public List<Endereco> getEnderecosLista() {
		
		List<Endereco> lista = new ArrayList<>();
		ResultSet rst = this.getEnderecos();		
		try {
			while(rst.next()) {
				var bean = new Endereco();
				bean.setId(rst.getInt("id_endereco"));
				bean.setRua(rst.getString("rua"));
				bean.setNumero(rst.getString("numero"));
				bean.setBairro(rst.getString("bairro"));
				bean.setCep(rst.getString("cep"));
				bean.setIdCliente(rst.getInt("id_cliente"));
				bean.setNomeCliente(rst.getString("nome"));
				lista.add(bean);				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getEnderecosLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getEnderecosLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public List<Endereco> getEnderecosByIdLista(int id) {
		
		List<Endereco> lista = new ArrayList<>();		
		ResultSet rst = this.getEnderecosById(String.valueOf(id));		
		try {
			while(rst.next()) {
				var bean = new Endereco();
				bean.setId(rst.getInt("id_endereco"));
				bean.setRua(rst.getString("rua"));
				bean.setNumero(rst.getString("numero"));
				bean.setBairro(rst.getString("bairro"));
				bean.setCep(rst.getString("cep"));
				bean.setIdCliente(rst.getInt("id_cliente"));
				bean.setNomeCliente(rst.getString("nome"));
				lista.add(bean);
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getEnderecosLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getEnderecosLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public List<Endereco> getEnderecosByIdClienteLista(int id) {
		
		List<Endereco> lista = new ArrayList<>();		
		ResultSet rst = this.getEnderecosByIdCliente(String.valueOf(id));		
		try {
			while(rst.next()) {
				var bean = new Endereco();
				bean.setId(rst.getInt("id_endereco"));
				bean.setRua(rst.getString("rua"));
				bean.setNumero(rst.getString("numero"));
				bean.setBairro(rst.getString("bairro"));
				bean.setCep(rst.getString("cep"));
				bean.setIdCliente(rst.getInt("id_cliente"));
				bean.setNomeCliente(rst.getString("nome"));
				lista.add(bean);
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getEnderecosLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getEnderecosLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public int insertEndereco(Endereco endereco) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlInsertEndereco);
			pstm.setString(1, endereco.getRua());
			pstm.setString(2, endereco.getNumero());
			pstm.setString(3, endereco.getBairro());
			pstm.setString(4, endereco.getCep());
			pstm.setInt(5, endereco.getIdCliente());
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no insertEndereco SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no insertEndereco: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	@Override
	public int updateEndereco(int id, Endereco endereco) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlUpdateEndereco);
			pstm.setString(1, endereco.getRua());
			pstm.setString(2, endereco.getNumero());
			pstm.setString(3, endereco.getBairro());
			pstm.setString(4, endereco.getCep());
			pstm.setInt(5, endereco.getId());
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no updateEndereco SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no updateEndereco: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	@Override
	public int deleteEndereco(int id) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlDeleteEndereco);
			pstm.setInt(1, id);
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		}
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no deleteEndereco SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no deleteEndereco: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	protected ResultSet getEnderecos() {
		return super.getResultSet(sqlSelectEnderecos);
	}
	
	protected ResultSet getEnderecosById(String id) {
		return super.getResultSet(sqlSelectEnderecosById, id);
	}	
	
	protected ResultSet getEnderecosByIdCliente(String id) {
		return super.getResultSet(sqlSelectEnderecosByIdCliente, id);
	}
	
}
