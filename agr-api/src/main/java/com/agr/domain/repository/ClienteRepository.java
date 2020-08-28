package com.agr.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agr.domain.pojo.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	List<Cliente> findByNome(String nome);
	List<Cliente> findByCpf(String cpf);
	List<Cliente> findByTelefone(String telefone);
	
	List<Cliente> findByNomeContaining(String nome);
	List<Cliente> findByEmailContaining(String email);
	
	Cliente findByEmail(String email);
		
}
