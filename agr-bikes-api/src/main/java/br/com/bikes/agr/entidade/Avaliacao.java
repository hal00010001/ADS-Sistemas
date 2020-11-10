package br.com.bikes.agr.entidade;

import java.security.Timestamp;

public class Avaliacao {

	private int id;
	private String comentario;
	private double nota;
	private Timestamp dataInclusao;
	private int idCliente;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
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
	
}
