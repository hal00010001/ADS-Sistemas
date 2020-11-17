package br.com.bikes.agr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.bikes.agr.config.ConnectionPool;
import br.com.bikes.agr.entidade.NotaFiscal;
import br.com.bikes.agr.entidade.Relatorio;
import br.com.bikes.agr.interfaces.RelatorioInterface;

public class RelatorioDAO extends ConnectionPool implements RelatorioInterface	{
	
	private final String sqlSelectMaisVendidos = "select count(*) as contador, pdd.id_produto as idProduto, pdt.descricao as nomeProduto from pedido as pdd, produto as pdt where pdd.id_produto = pdt.id_produto group by pdd.id_produto order by contador desc";
	private final String sqlSelectVendasMensais = "select id_nota, data_inclusao, nfc.id_cliente, nfc.numero_pedido as numPedido, cli.nome as nomeCliente, pdt.descricao as nomeProduto, preco from nota_fiscal as nfc, cliente as cli, pedido as pdo, produto as pdt where nfc.numero_pedido = pdo.numero_pedido and nfc.id_cliente = cli.id_cliente and pdo.id_produto = pdt.id_produto and data_inclusao >= ? and data_inclusao <= ?";
	
	@Override
	public List<Relatorio> getMaisVendidosLista() {
		
		List<Relatorio> lista = new ArrayList<>();
		ResultSet rst = this.getMaisVendidos();	
		
		try {
			while(rst.next()) {
												
				var bean = new Relatorio();
				bean.setContador(rst.getInt("contador"));
				bean.setIdProduto(rst.getInt("idProduto"));
				bean.setNomeProduto(rst.getString("nomeProduto"));								
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getMaisVendidosLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getMaisVendidosLista: " + ex.getMessage());
        }		
		return lista;
		
	}
	
	@Override
	public List<NotaFiscal> getVendasMensaisLista(String dataInicio, String dataTermino) {
		
		List<NotaFiscal> lista = new ArrayList<>();
		ResultSet rst = this.getVendasMensais(dataInicio, dataTermino);	
		
		try {
			while(rst.next()) {
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
								
				var bean = new NotaFiscal();
				bean.setId(rst.getInt("id_nota"));
				bean.setDataInclusao(df.format(rst.getTimestamp("data_inclusao")));				
				bean.setIdCliente(rst.getInt("id_cliente"));
				bean.setNumeroPedido(rst.getInt("numPedido"));
				bean.setNomeCliente(rst.getString("nomeCliente"));
				bean.setNomeProduto(rst.getString("nomeProduto"));
				bean.setPreco(rst.getDouble("preco"));
				lista.add(bean);
				
			}			
		}
		catch(SQLException sqle) {
			System.out.println("Erro no getVendasMensaisLista SQL: " + sqle.getMessage());
		}
		catch (Exception ex){
            System.out.println("Erro no getVendasMensaisLista: " + ex.getMessage());
        }		
		return lista;
		
	}
	
	protected ResultSet getMaisVendidos() {
		return super.getResultSet(sqlSelectMaisVendidos);
	}
	
	protected ResultSet getVendasMensais(String dataInicio, String dataTermino) {
		return super.getResultSet(sqlSelectVendasMensais, dataInicio, dataTermino);
	}
	
}
