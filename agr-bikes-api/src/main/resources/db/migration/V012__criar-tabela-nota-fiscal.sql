create table nota_fiscal (
	
	id_nota bigint not null auto_increment,
	data_inclusao datetime not null,
	numero_nota bigint not null,
	id_cliente bigint not null,
	numero_pedido bigint not null,
			
	primary key (id_nota)
	
);

alter table nota_fiscal add constraint fk_nota_cliente
foreign key (id_cliente) references cliente (id_cliente);