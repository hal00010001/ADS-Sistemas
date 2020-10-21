create table preco (
	
	id_preco bigint not null auto_increment,
	id_produto bigint,
	valor double,
			
	primary key (id_preco)
	
);

alter table preco add constraint fk_preco_produto
foreign key (id_produto) references produto (id_produto)