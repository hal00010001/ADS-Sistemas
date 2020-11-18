package br.com.bikes.agr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bikes.agr.config.ConnectionPool;
import br.com.bikes.agr.entidade.Pedido;
import br.com.bikes.agr.interfaces.PedidoInterface;

public class PedidoDAO extends ConnectionPool implements PedidoInterface {

	private final String sqlSelectPedidos = "select id_pedido, numero_pedido as numPedido, status_pedido as status, pdo.id_cliente, pdo.id_produto, pdt.descricao as nomeProduto, cli.nome as nomeCliente from pedido as pdo, produto as pdt, cliente as cli where pdo.id_produto = pdt.id_produto and pdo.id_cliente = cli.id_cliente order by numero_pedido";
	private final String sqlSelectPedidoRecente = "select id_pedido, numero_pedido as numPedido, status_pedido as status, pdo.id_cliente, pdo.id_produto, pdt.descricao as nomeProduto, cli.nome as nomeCliente from pedido as pdo, produto as pdt, cliente as cli where pdo.id_produto = pdt.id_produto and pdo.id_cliente = cli.id_cliente and status_pedido = 0 order by numPedido desc limit 1";
	private final String sqlSelectPedidoRecenteNovo = "select id_pedido, numero_pedido as numPedido, status_pedido as status, pdo.id_cliente, pdo.id_produto, pdt.descricao as nomeProduto, cli.nome as nomeCliente from pedido as pdo, produto as pdt, cliente as cli where pdo.id_produto = pdt.id_produto and pdo.id_cliente = cli.id_cliente and status_pedido = 1 order by numPedido desc limit 1";
	private final String sqlSelectPedidosByIdProduto = "select id_pedido, numero_pedido as numPedido, status_pedido as status, pdo.id_cliente, pdo.id_produto, pdt.descricao as nomeProduto, cli.nome as nomeCliente from pedido as pdo, produto as pdt, cliente as cli where pdo.id_produto = pdt.id_produto and pdo.id_cliente = cli.id_cliente where pdo.id_produto = ?";
	private final String sqlSelectPedidosByIdCliente = "select id_pedido, numero_pedido as numPedido, status_pedido as status, pdo.id_cliente, pdo.id_produto, pdt.descricao as nomeProduto, cli.nome as nomeCliente from pedido as pdo, produto as pdt, cliente as cli where pdo.id_produto = pdt.id_produto and pdo.id_cliente = cli.id_cliente where pdo.id_cliente = ?";
	private final String sqlSelectPedidosByIdClienteRecente = "select id_pedido, numero_pedido as numPedido, status_pedido as status, pdo.id_cliente, pdo.id_produto, pdt.descricao as nomeProduto, cli.nome as nomeCliente from pedido as pdo, produto as pdt, cliente as cli where pdo.id_produto = pdt.id_produto and pdo.id_cliente = cli.id_cliente and pdo.id_cliente = ? and status_pedido = 0 order by numPedido desc limit 1";
	private final String sqlSelectPedidoByNumeroPedido = "select count(*) as quantidade, numero_pedido, status_pedido, pdt.descricao as nomeProduto, cli.nome as nomeCliente from pedido as pdo, produto as pdt, cliente as cli where pdo.id_produto = pdt.id_produto and pdo.id_cliente = cli.id_cliente and numero_pedido = ? group by pdo.id_produto, pdo.id_cliente, pdo.numero_pedido, pdo.status_pedido";	
	private final String sqlSelectPedidoSomaByNumeroPedido = "select sum(prc.valor) as soma from pedido as pdd, produto as pdt, preco as prc where pdd.numero_pedido = ? and pdd.status_pedido = 1 and pdd.id_produto = pdt.id_produto group by prc.valor";
	private final String sqlInsertPedido = "insert into pedido (numero_pedido, status_pedido, id_produto, id_cliente) values (?, 0, ?, ?)";
	private final String sqlUpdatePedido = "update pedido set status_pedido = ? where numero_pedido = ?";											
	private final String sqlDeletePedido = "delete from pedido where id_pedido = ?";
	
	@Override
	public List<Pedido> getPedidosLista() {
		
		List<Pedido> lista = new ArrayList<>();
		ResultSet rst = this.getPedidos();	
		
		try {
			while(rst.next()) {
								
				var bean = new Pedido();
				bean.setId(rst.getInt("id_pedido"));
				bean.setNumeroPedido(rst.getInt("numPedido"));
				bean.setStatus(rst.getInt("status"));
				bean.setIdCliente(rst.getInt("id_cliente"));
				bean.setIdProduto(rst.getInt("id_produto"));
				bean.setNomeCliente(rst.getString("nomeCliente"));
				bean.setNomeProduto(rst.getString("nomeProduto"));
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getPedidosLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getPedidosLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public int getPedidoRecenteLista() {
			
		int resultado = 0;
		ResultSet rst = this.getPedidoRecente();	
		
		try {
			if (rst.next()) {								
				resultado = rst.getInt("numPedido");				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getPedidoRecenteLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getPedidoRecenteLista: " + ex.getMessage());
        }
		System.out.println("Pedido: " + resultado);
		return resultado;
		
	}

	@Override
	public int getPedidoRecenteNovoLista() {
			
		int resultado = 0;
		ResultSet rst = this.getPedidoRecenteNovo();	
		
		try {
			if (rst.next()) {								
				resultado = rst.getInt("numPedido");				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getPedidoRecenteNovoLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getPedidoRecenteNovoLista: " + ex.getMessage());
        }
		System.out.println("Pedido: " + resultado);
		return resultado;
		
	}
	
	@Override
	public List<Pedido> getPedidosByIdProdutoLista(int id) {
		
		List<Pedido> lista = new ArrayList<>();
		ResultSet rst = this.getPedidosByIdProduto(String.valueOf(id));	
		
		try {
			while(rst.next()) {
								
				var bean = new Pedido();
				bean.setId(rst.getInt("id_pedido"));
				bean.setNumeroPedido(rst.getInt("numero_pedido"));
				bean.setStatus(rst.getInt("status"));
				bean.setIdCliente(rst.getInt("id_cliente"));
				bean.setIdProduto(rst.getInt("id_produto"));
				bean.setNomeCliente(rst.getString("nomeCliente"));
				bean.setNomeProduto(rst.getString("nomeProduto"));			
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getPedidosByIdProdutoLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getPedidosByIdProdutoLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public List<Pedido> getPedidosByIdClienteLista(int id) {
		
		List<Pedido> lista = new ArrayList<>();
		ResultSet rst = this.getPedidosByIdCliente();	
		
		try {
			while(rst.next()) {
								
				var bean = new Pedido();
				bean.setId(rst.getInt("id_pedido"));
				bean.setNumeroPedido(rst.getInt("numero_pedido"));
				bean.setStatus(rst.getInt("status"));
				bean.setIdCliente(rst.getInt("id_cliente"));
				bean.setIdProduto(rst.getInt("id_produto"));
				bean.setNomeCliente(rst.getString("nomeCliente"));
				bean.setNomeProduto(rst.getString("nomeProduto"));			
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getPedidosLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getPedidosLista: " + ex.getMessage());
        }		
		return lista;
		
	}
	
	@Override
	public List<Pedido> getPedidoByNumeroPedido(int numeroPedido) {
		
		List<Pedido> lista = new ArrayList<>();
		ResultSet rst = this.getPedidoByNumeroPedido(String.valueOf(numeroPedido));
		
		try {
			while(rst.next()) {
								
				var bean = new Pedido();
				bean.setId(rst.getInt("id_pedido"));
				bean.setNumeroPedido(rst.getInt("numero_pedido"));
				bean.setStatus(rst.getInt("status"));
				bean.setIdCliente(rst.getInt("id_cliente"));
				bean.setIdProduto(rst.getInt("id_produto"));
				bean.setNomeCliente(rst.getString("nomeCliente"));
				bean.setNomeProduto(rst.getString("nomeProduto"));			
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getPedidoByNumeroPedidoLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getPedidoByNumeroPedidoLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public double getPedidoSomaByNumeroPedido(int numeroPedido) {
		
		double soma = 0;
		ResultSet rst = this.getPedidoSomaByNumeroPedido(String.valueOf(numeroPedido));
		
		try {
			if(rst.next()) {
				
				soma = rst.getDouble("soma");
				System.out.println("Soma: " + soma);
												
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getPedidoSomaByNumeroPedidoLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getPedidoSomaByNumeroPedidoLista: " + ex.getMessage());
        }		
		return soma;
		
	}
	
	@Override
	public int getPedidosByIdClienteRecenteLista(int id) {
		
		int resultado = 0;
		ResultSet rst = this.getPedidosByIdClienteRecente(String.valueOf(id));	
		
		try {
			if (rst.next()) {												
				resultado = rst.getInt("numPedido");							
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getPedidoIdClienteRecenteLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getPedidoIdClienteRecenteLista: " + ex.getMessage());
        }		
		return resultado;
		
	}

	@Override
	public int insertPedido(Pedido pedido) {
		
		int linhasAlteradas = 0;
		int numeroPedido = 0;
		int numeroPedidoRecente = 0;
		int numeroPedidoCliente = 0;
		int numeroPedidoNovo = 0;
						
		numeroPedidoRecente = this.getPedidoRecenteLista();
		numeroPedidoCliente = this.getPedidosByIdClienteRecenteLista(pedido.getIdCliente());
		numeroPedidoNovo = this.getPedidoRecenteNovoLista();
				
		if (numeroPedidoCliente != 0) {
			numeroPedido = numeroPedidoCliente;
		}
		else if (numeroPedidoRecente != 0) {
			numeroPedido = numeroPedidoRecente + 1;
		}
		else {
			numeroPedido = numeroPedidoNovo + 1;
		}
				
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlInsertPedido);
			pstm.setInt(1, numeroPedido);			
			pstm.setInt(2, pedido.getIdProduto());
			pstm.setInt(3, pedido.getIdCliente());
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no insertPedido SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no insertPedido: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}
	
	@Override
	public int updatePedido(int numPedido) {
		
		int linhasAlteradas = 0;
				
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlUpdatePedido);
			pstm.setInt(1, 1);
			pstm.setInt(2, numPedido);
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();			
		}
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no updatePedido SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no updatePedido: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	@Override
	public int deletePedido(int id) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlDeletePedido);
			pstm.setInt(1, id);
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		}
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no deletePedido SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no deletePedido: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}	
	
	protected ResultSet getPedidos() {
		return super.getResultSet(sqlSelectPedidos);
	}
	
	protected ResultSet getPedidoRecente() {
		return super.getResultSet(sqlSelectPedidoRecente);
	}
	
	protected ResultSet getPedidoRecenteNovo() {
		return super.getResultSet(sqlSelectPedidoRecenteNovo);
	}
	
	protected ResultSet getPedidosByIdCliente() {
		return super.getResultSet(sqlSelectPedidosByIdCliente);
	}
	
	protected ResultSet getPedidosByIdProduto(String id) {
		return super.getResultSet(sqlSelectPedidosByIdProduto, id);
	}
	
	protected ResultSet getPedidosByIdClienteRecente(String id) {
		return super.getResultSet(sqlSelectPedidosByIdClienteRecente, id);
	}
	
	protected ResultSet getPedidoByNumeroPedido(String numPedido) {
		return super.getResultSet(sqlSelectPedidoByNumeroPedido, numPedido);
	}
	
	protected ResultSet getPedidoSomaByNumeroPedido(String numPedido) {
		return super.getResultSet(sqlSelectPedidoSomaByNumeroPedido, numPedido);
	}
	
}
