package com.agr.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agr.api.model.EnderecoModel;
import com.agr.domain.pojo.Endereco;
import com.agr.domain.repository.EnderecoRepository;
import com.agr.domain.service.CadastroEnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private CadastroEnderecoService enderecoService;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco criar(@Valid @RequestBody Endereco endereco) {		
		return enderecoService.criar(endereco);		
	}
	
	@GetMapping
	public List<Endereco> listar(){		
		return enderecoRepository.findAll();		
	}
	
	@GetMapping("/{enderecoId}")
	public ResponseEntity<EnderecoModel> buscar(@PathVariable Long enderecoId){
		
		Optional<Endereco> endereco = enderecoRepository.findById(enderecoId);
		if(endereco.isPresent()) {
			EnderecoModel model = modelMapper.map(endereco.get(), EnderecoModel.class);
			return ResponseEntity.ok(model);			
		}
		return ResponseEntity.notFound().build();
		
	}
	
}
