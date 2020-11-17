package br.com.bikes.agr.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import br.com.bikes.agr.rest.AvaliacaoService;
import br.com.bikes.agr.rest.CategoriaService;
import br.com.bikes.agr.rest.ClienteService;
import br.com.bikes.agr.rest.EnderecoService;
import br.com.bikes.agr.rest.EstoqueService;
import br.com.bikes.agr.rest.NotaFiscalService;
import br.com.bikes.agr.rest.PedidoService;
import br.com.bikes.agr.rest.PrecoService;
import br.com.bikes.agr.rest.ProdutoService;
import br.com.bikes.agr.rest.RelatorioService;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		
		register(ClienteService.class).
		register(EnderecoService.class).
		register(AvaliacaoService.class).
		register(ProdutoService.class).
		register(CategoriaService.class).
		register(EstoqueService.class).
		register(PrecoService.class).
		register(PedidoService.class).
		register(NotaFiscalService.class).
		register(RelatorioService.class);
		
	}
	
}
