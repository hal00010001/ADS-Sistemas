package br.com.bikes.agr.entidade;

public class NotaFiscal {

	private int id;
	private String dataInclusao;
	private int numeroNota;
	private int idCliente;
	private int numeroPedido;
	private double Preco;
	private String nomeCliente;
	private String nomeProduto;	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public String getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(String dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public int getNumeroNota() {
		return numeroNota;
	}
	public void setNumeroNota(int numeroNota) {
		this.numeroNota = numeroNota;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}	
	public int getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}	
	public double getPreco() {
		return Preco;
	}
	public void setPreco(double preco) {
		Preco = preco;
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
