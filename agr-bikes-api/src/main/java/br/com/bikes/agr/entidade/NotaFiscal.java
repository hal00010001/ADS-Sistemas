package br.com.bikes.agr.entidade;

import java.security.Timestamp;

public class NotaFiscal {

	private int id;
	private Timestamp dataInclusao;
	private int idCliente;
	private int idPedido;	
	private int idProduto;
	private String nomeCliente;
	private String nomeProduto;	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Timestamp dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
		
}
