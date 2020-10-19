package br.com.bikes.agr.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import br.com.bikes.agr.rest.AvaliacaoService;
import br.com.bikes.agr.rest.CategoriaService;
import br.com.bikes.agr.rest.ClienteService;
import br.com.bikes.agr.rest.EnderecoService;
import br.com.bikes.agr.rest.ProdutoService;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		
		register(ClienteService.class).
		register(EnderecoService.class).
		register(AvaliacaoService.class).
		register(ProdutoService.class).
		register(CategoriaService.class);
		
	}
	
}
