create table estoque (
	
	id_estoque bigint not null auto_increment,
	id_produto bigint,
	quantidade int,
			
	primary key (id_estoque)
	
);

alter table estoque add constraint fk_estoque_produto
foreign key (id_produto) references produto (id_produto)