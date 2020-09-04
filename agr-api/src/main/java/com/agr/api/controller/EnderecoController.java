package com.agr.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agr.domain.pojo.Endereco;
import com.agr.domain.service.CadastroEnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private CadastroEnderecoService enderecoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco criar(@Valid @RequestBody Endereco endereco) {
		
		return enderecoService.criar(endereco);
		
	}
	
}
