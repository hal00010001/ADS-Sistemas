package br.com.bikes.agr.entidade;

public class Login {

	private int id;
	private String usuario;
	private String senha;
	private int status;	
	private int idGrupo;
	private int idPermissao;
	private String nomeGrupo;
	private String descricaoGrupo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}	
	public int getIdPermissao() {
		return idPermissao;
	}
	public void setIdPermissao(int idPermissao) {
		this.idPermissao = idPermissao;
	}
	public String getNomeGrupo() {
		return nomeGrupo;
	}
	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}
	public String getDescricaoGrupo() {
		return descricaoGrupo;
	}
	public void setDescricaoGrupo(String descricaoGrupo) {
		this.descricaoGrupo = descricaoGrupo;
	}
		
}
