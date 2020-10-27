package br.com.bikes.agr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.bikes.agr.config.ConnectionPool;
import br.com.bikes.agr.entidade.NotaFiscal;
import br.com.bikes.agr.interfaces.NotaFiscalInterface;

public class NotaFiscalDAO extends ConnectionPool implements NotaFiscalInterface {

	private final String sqlSelectNotasFiscais = "select id_nota, data_inclusao, numero_nota, nfc.id_cliente, nfc.numero_pedido as numPedido, cli.nome as nomeCliente, pdo.descricao as nomeProduto from nota_fiscal as nfc, cliente as cli, pedido as pdo, produto as pdt where nfc.numero_pedido = pdo.numero_pedido and nfc.id_cliente = cli.id_cliente and pdo.id_produto = pdt.descricao";
	private final String sqlSelectNotasFiscaisById = "select id_nota, data_inclusao, numero_nota, nfc.id_cliente, nfc.numero_pedido as numPedido, cli.nome as nomeCliente, pdo.descricao as nomeProduto from nota_fiscal as nfc, cliente as cli, pedido as pdo, produto as pdt where nfc.numero_pedido = pdo.numero_pedido and nfc.id_cliente = cli.id_cliente and pdo.id_produto = pdt.descricao and id_nota = ?";
	private final String sqlSelectNotasFiscaisByNumeroNota = "select id_nota, data_inclusao, numero_nota, nfc.id_cliente, nfc.numero_pedido as numPedido, cli.nome as nomeCliente, pdo.descricao as nomeProduto from nota_fiscal as nfc, cliente as cli, pedido as pdo, produto as pdt where nfc.numero_pedido = pdo.numero_pedido and nfc.id_cliente = cli.id_cliente and pdo.id_produto = pdt.descricao and numero_nota = ?";	
	private final String sqlSelectNotasFiscaisByNumeroPedido = "select id_nota, data_inclusao, numero_nota, nfc.id_cliente, nfc.numero_pedido as numPedido, cli.nome as nomeCliente, pdo.descricao as nomeProduto from nota_fiscal as nfc, cliente as cli, pedido as pdo, produto as pdt where nfc.numero_pedido = pdo.numero_pedido and nfc.id_cliente = cli.id_cliente and pdo.id_produto = pdt.descricao and nfc.numero_pedido = ?";
	private final String sqlSelectNotasFiscaisByIdCliente = "select id_nota, data_inclusao, numero_nota, nfc.id_cliente, nfc.numero_pedido as numPedido, cli.nome as nomeCliente, pdo.descricao as nomeProduto from nota_fiscal as nfc, cliente as cli, pedido as pdo, produto as pdt where nfc.numero_pedido = pdo.numero_pedido and nfc.id_cliente = cli.id_cliente and pdo.id_produto = pdt.descricao and nfc.id_cliente = ?";
	private final String sqlInsertNotaFiscal = "insert into nota_fiscal (data_inclusao, numero_nota, id_cliente, numero_pedido) values (now(), ?, ?, ?)";
	private final String sqlUpdateNotaFiscal = "update nota_fiscal set numero_nota = ?, id_cliente = ?, numero_pedido = ? where id_nota = ?";
	private final String sqlDeleteNotaFiscal = "delete from nota_fiscal where id_nota = ?";
	
	@Override
	public List<NotaFiscal> getNotasFiscaisLista() {
		
		List<NotaFiscal> lista = new ArrayList<>();
		ResultSet rst = this.getNotasFiscais();	
		
		try {
			while(rst.next()) {
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
								
				var bean = new NotaFiscal();
				bean.setId(rst.getInt("id_nota"));
				bean.setDataInclusao(df.format(rst.getTimestamp("data_inclusao")));
				bean.setNumeroNota(rst.getInt("numero_nota"));
				bean.setIdCliente(rst.getInt("id_cliente"));
				bean.setNumeroPedido(rst.getInt("numero_pedido"));
				bean.setNomeCliente(rst.getString("nomeCliente"));
				bean.setNomeProduto(rst.getString("nome_produto"));
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getNotaFiscalLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getNotaFiscalLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public List<NotaFiscal> getNotaFiscalByIdLista(int id) {
		
		List<NotaFiscal> lista = new ArrayList<>();
		ResultSet rst = this.getNotasFiscaisById(String.valueOf(id));	
		
		try {
			while(rst.next()) {
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
								
				var bean = new NotaFiscal();
				bean.setId(rst.getInt("id_nota"));
				bean.setDataInclusao(df.format(rst.getTimestamp("data_inclusao")));
				bean.setNumeroNota(rst.getInt("numero_nota"));
				bean.setIdCliente(rst.getInt("id_cliente"));
				bean.setNumeroPedido(rst.getInt("numero_pedido"));
				bean.setNomeCliente(rst.getString("nomeCliente"));
				bean.setNomeProduto(rst.getString("nome_produto"));
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getNotaFiscalByIdLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getNotaFiscalByIdLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public List<NotaFiscal> getNotaFiscalByNumeroPedidoLista(int numeroPedido) {
		
		List<NotaFiscal> lista = new ArrayList<>();
		ResultSet rst = this.getNotasFiscaisByNumeroPedido(String.valueOf(numeroPedido));	
		
		try {
			while(rst.next()) {
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
								
				var bean = new NotaFiscal();
				bean.setId(rst.getInt("id_nota"));
				bean.setDataInclusao(df.format(rst.getTimestamp("data_inclusao")));
				bean.setNumeroNota(rst.getInt("numero_nota"));
				bean.setIdCliente(rst.getInt("id_cliente"));
				bean.setNumeroPedido(rst.getInt("numero_pedido"));
				bean.setNomeCliente(rst.getString("nomeCliente"));
				bean.setNomeProduto(rst.getString("nome_produto"));
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getNotaFiscalByNumeroPedidoLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getNotaFiscalByNumeroPedidoLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public List<NotaFiscal> getNotaFiscalByIdClienteLista(int numPedido) {
		
		List<NotaFiscal> lista = new ArrayList<>();
		ResultSet rst = this.getNotasFiscaisByIdCliente(String.valueOf(numPedido));	
		
		try {
			while(rst.next()) {
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
								
				var bean = new NotaFiscal();
				bean.setId(rst.getInt("id_nota"));
				bean.setDataInclusao(df.format(rst.getTimestamp("data_inclusao")));
				bean.setNumeroNota(rst.getInt("numero_nota"));
				bean.setIdCliente(rst.getInt("id_cliente"));
				bean.setNumeroPedido(rst.getInt("numero_pedido"));
				bean.setNomeCliente(rst.getString("nomeCliente"));
				bean.setNomeProduto(rst.getString("nome_produto"));
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getNotaFiscalByIdClienteLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getNotaFiscalByIdClienteLista: " + ex.getMessage());
        }		
		return lista;
		
	}
	
	@Override
	public List<NotaFiscal> getNotaFiscalByNumeroNotaLista(int numNota) {
		
		List<NotaFiscal> lista = new ArrayList<>();
		ResultSet rst = this.getNotasFiscaisByNumeroNota(String.valueOf(numNota));	
		
		try {
			while(rst.next()) {
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
								
				var bean = new NotaFiscal();
				bean.setId(rst.getInt("id_nota"));
				bean.setDataInclusao(df.format(rst.getTimestamp("data_inclusao")));
				bean.setNumeroNota(rst.getInt("numero_nota"));
				bean.setIdCliente(rst.getInt("id_cliente"));
				bean.setNumeroPedido(rst.getInt("numero_pedido"));
				bean.setNomeCliente(rst.getString("nomeCliente"));
				bean.setNomeProduto(rst.getString("nome_produto"));
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getNotaFiscalByNumeroNotaLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getNotaFiscalByNumeroNotaLista: " + ex.getMessage());
        }		
		return lista;
		
	}

	@Override
	public int insertNotaFiscal(NotaFiscal notaFiscal) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlInsertNotaFiscal);
			pstm.setInt(1, notaFiscal.getNumeroNota());
			pstm.setInt(2, notaFiscal.getIdCliente());
			pstm.setInt(3, notaFiscal.getNumeroPedido());
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no insertNotaFiscal SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no insertNotaFiscal: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	@Override
	public int updateNotaFiscal(int id, NotaFiscal notaFiscal) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlUpdateNotaFiscal);
			pstm.setInt(1, notaFiscal.getNumeroNota());
			pstm.setInt(2, notaFiscal.getIdCliente());
			pstm.setInt(3, notaFiscal.getNumeroPedido());
			pstm.setInt(4, id);
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		} 
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no updateNotaFiscal SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no updateNotaFiscal: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}

	@Override
	public int deleteNotaFiscal(int id) {
		
		int linhasAlteradas = 0;
		
		PreparedStatement pstm;
		try {
			pstm = super.getConnection().prepareStatement(sqlDeleteNotaFiscal);
			pstm.setInt(1, id);
			linhasAlteradas = pstm.executeUpdate();
			pstm.close();
		}
		catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Erro no deleteNotaFiscal SQL: " + sqle.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Erro no deleteNotaFiscal: " + ex.getMessage());
		}
		
		return linhasAlteradas;
		
	}
	
	protected ResultSet getNotasFiscais() {
		return super.getResultSet(sqlSelectNotasFiscais);
	}
	
	protected ResultSet getNotasFiscaisById(String id) {
		return super.getResultSet(sqlSelectNotasFiscaisById, id);
	}
	
	protected ResultSet getNotasFiscaisByIdCliente(String id) {
		return super.getResultSet(sqlSelectNotasFiscaisByIdCliente, id);
	}
		
	protected ResultSet getNotasFiscaisByNumeroNota(String numNota) {
		return super.getResultSet(sqlSelectNotasFiscaisByNumeroNota, numNota);
	}
	
	protected ResultSet getNotasFiscaisByNumeroPedido(String numPedido) {
		return super.getResultSet(sqlSelectNotasFiscaisByNumeroPedido, numPedido);
	}
	
}
