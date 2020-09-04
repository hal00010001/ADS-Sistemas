package com.agr.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agr.domain.exception.BusinessException;
import com.agr.domain.pojo.Cliente;
import com.agr.domain.pojo.Endereco;
import com.agr.domain.repository.ClienteRepository;
import com.agr.domain.repository.EnderecoRepository;

@Service
public class CadastroEnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Endereco criar(Endereco endereco) {
		
		Cliente cliente = clienteRepository.findById(endereco.getCliente().getId())
				.orElseThrow(() -> new BusinessException("Cliente não existe"));
		endereco.setCliente(cliente);
		
		return enderecoRepository.save(endereco);
		
	}
	
}
