create table produto (
	id_produto bigint not null auto_increment,
	descricao varchar(200) not null,
	categoria integer,
		
	primary key(id_produto)
);