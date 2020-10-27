create table pedido (
	
	id_pedido bigint not null auto_increment,
	numero_pedido bigint not null,
	status int not null,
	id_produto bigint not null,
	id_cliente bigint not null,
			
	primary key (id_pedido)
	
);

alter table pedido add constraint fk_pedido_produto
foreign key (id_produto) references produto (id_produto);

alter table pedido add constraint fk_pedido_cliente
foreign key (id_cliente) references cliente (id_cliente);