package com.agr.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agr.domain.exception.BusinessException;
import com.agr.domain.pojo.Cliente;
import com.agr.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public Cliente salvar(Cliente cliente) {	
		
		Cliente clienteExiste = repository.findByEmail(cliente.getEmail());
		if (clienteExiste != null && !clienteExiste.equals(cliente)) {
			throw new BusinessException("E-mail já cadastrado.");
		}		
		return repository.save(cliente);
		
	}
	
	public void excluir(Long clienteId) {
		repository.deleteById(clienteId);
	}
	
}
