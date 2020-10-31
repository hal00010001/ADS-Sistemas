package br.com.bikes.agr.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.bikes.agr.dao.LoginDAO;
import br.com.bikes.agr.entidade.Login;

public class LoginService {

	private LoginDAO dao;
	
	@PostConstruct
	private void init() {
		dao = new LoginDAO();
	}
	
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Login> listarUsuarios(){
		
		List<Login> lista = null;
		
		try {
			lista = dao.getLogin();
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		return lista;
		
	}
	
	@GET
	@Path("/autenticar")
	@Consumes(MediaType.APPLICATION_JSON)	
	public boolean autenticarUsuario(Login login){
		
		boolean resultado = false;
		
		try {
			resultado = dao.getLoginFromUsuarioSenha(login);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}
		return resultado;
		
	}
	
	@GET
	@Path("/permissao/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Login> listarPermissoes(@PathParam("id") int id){
		
		List<Login> lista = null;
		
		try {
			lista = dao.getPermissoesLista(id);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}		
		return lista;
		
	}
			
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String adicionarUsuario(Login login) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.insertLogin(login);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}
		if(linhasAlteradas > 0) {
			msg = "Usuário salvo com sucesso!";
		}
		else {
			msg = "Usuário não foi salvo!";
		}				
		return msg;
		
	}
	
	@POST	
	@Path("/grupo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String adicionarGrupo(Login login) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.insertGrupo(login);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}
		if(linhasAlteradas > 0) {
			msg = "Grupo salvo com sucesso!";
		}
		else {
			msg = "Grupo não foi salvo!";
		}				
		return msg;
		
	}
	
	@POST
	@Path("/permissao")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String adicionarPermissao(Login login) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.insertLogin(login);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}
		if(linhasAlteradas > 0) {
			msg = "Permissão salva com sucesso!";
		}
		else {
			msg = "Permissão não foi salva!";
		}				
		return msg;
		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String atualizarUsuario(@PathParam("id") int id, Login login) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.updateLogin(id, login);
		}
		catch (Exception ex) {
			msg = "Erro ao atualizar o usuário!";
		}
		if(linhasAlteradas > 0) {
			msg = "Usuário salvo com sucesso!";
		}
		else {
			msg = "Usuário não foi salvo!";
		}		
		return msg;
		
	}
	
	@PUT
	@Path("/senha/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String atualizarSenha(@PathParam("id") int id, Login login) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.updatePassword(id, login);
		}
		catch (Exception ex) {
			msg = "Erro ao atualizar a senha!";
		}
		if(linhasAlteradas > 0) {
			msg = "Senha salva com sucesso!";
		}
		else {
			msg = "Senha não foi salva!";
		}		
		return msg;
		
	}
	
	@PUT
	@Path("/grupo/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String atualizarGrupo(@PathParam("id") int id, Login login) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.updateGrupo(id, login);
		}
		catch (Exception ex) {
			msg = "Erro ao atualizar o grupo!";
		}
		if(linhasAlteradas > 0) {
			msg = "Grupo salvo com sucesso!";
		}
		else {
			msg = "Grupo não foi salvo!";
		}		
		return msg;
		
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String removerUsuario(@PathParam("id") int id) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.deleteLogin(id);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}
		if(linhasAlteradas > 0) {
			msg = "Usuário removido com sucesso!";
		}
		else {
			msg = "Erro ao remover o usuário!";
		}		
		return msg;
		
	}
	
	@DELETE
	@Path("/grupo/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String removerGrupo(@PathParam("id") int id) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.deleteGrupo(id);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}
		if(linhasAlteradas > 0) {
			msg = "Grupo removido com sucesso!";
		}
		else {
			msg = "Erro ao remover o grupo!";
		}		
		return msg;
		
	}
	
	@DELETE
	@Path("/permissao/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String removerPermissao(@PathParam("id") int id) {
		
		String msg = "";
		int linhasAlteradas = 0;
		
		try {
			linhasAlteradas = dao.deletePermissao(id);
		}
		catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}
		if(linhasAlteradas > 0) {
			msg = "Permissao removida com sucesso!";
		}
		else {
			msg = "Erro ao remover a permissão!";
		}		
		return msg;
		
	}
	
}
