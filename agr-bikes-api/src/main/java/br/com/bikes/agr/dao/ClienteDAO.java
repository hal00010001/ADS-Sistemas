package br.com.bikes.agr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bikes.agr.config.ConnectionPool;
import br.com.bikes.agr.entidade.Cliente;
import br.com.bikes.agr.interfaces.ClienteInterface;

public class ClienteDAO extends ConnectionPool implements ClienteInterface {
	
	private final String sqlSelectClientes = "select id_cliente, nome, cpf, email, telefone from cliente";
	private final String sqlSelectClientesById = "select id_cliente, nome, cpf, email, telefone from cliente where id_cliente = ?";
	private final String sqlInsertCliente = "insert into cliente (nome, cpf, email, telefone) values (?, ?, ?, ?)";
	private final String sqlUpdateCliente = "update cliente set nome = ?, cpf = ?, email = ?, telefone = ? where id_cliente = ?";
	private final String sqlDeleteCliente = "delete from cliente where id_cliente = ?";

	@Override
	public List<Cliente> getClientesLista() {
		
		List<Cliente> lista = new ArrayList<>();		
		ResultSet rst = this.getClientes();		
		try {
			while(rst.next()) {
				var bean = new Cliente();
				bean.setId(rst.getInt("id_cliente"));
				bean.setNome(rst.getString("nome"));
				bean.setCpf(rst.getString("cpf"));
				bean.setEmail(rst.getString("email"));
				bean.setTelefone(rst.getString("telefone"));
				lista.add(bean);
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getClientesLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getClientesLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public List<Cliente> getClientesByIdLista(int id) {
		
		List<Cliente> lista = new ArrayList<>();		
		ResultSet rst = this.getClientesById(String.valueOf(id));		
		try {
			while(rst.next()) {
				var bean = new Cliente();
				bean.setId(rst.getInt("id_cliente"));
				bean.setNome(rst.getString("nome"));
				bean.setCpf(rst.getString("cpf"));
				bean.setEmail(rst.getString("email"));
				bean.setTelefone(rst.getString("telefone"));
				lista.add(bean);
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getClientesByIdLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getClientesByIdLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public int insertCliente(Cliente cliente) {
		
		int linhasAlteradas = 0;
					
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlInsertCliente);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCpf());
			pstm.setString(3, cliente.getEmail());
			pstm.setString(4, cliente.getTelefone());			
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no insertCliente SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no insertCliente: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	@Override
	public int updateCliente(int id, Cliente cliente) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlUpdateCliente);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCpf());
			pstm.setString(3, cliente.getEmail());
			pstm.setString(4, cliente.getTelefone());
			pstm.setInt(5, id);
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no updateCliente SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no updateCliente: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	@Override
	public int deleteCliente(int id) {
		
		int linhasAlteradas = 0;
				
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlDeleteCliente);
			pstm.setInt(1, id);
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		}
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no deleteCliente SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no deleteCliente: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}
	
	protected ResultSet getClientes() {
		return super.getResultSet(sqlSelectClientes);
	}
	
	protected ResultSet getClientesById(String id) {
		return super.getResultSet(sqlSelectClientesById, id);
	}
	
}
