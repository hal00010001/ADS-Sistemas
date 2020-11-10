package br.com.bikes.agr.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import br.com.bikes.agr.rest.ClienteService;
import br.com.bikes.agr.rest.EnderecoService;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(ClienteService.class).register(EnderecoService.class);
	}
	
}
