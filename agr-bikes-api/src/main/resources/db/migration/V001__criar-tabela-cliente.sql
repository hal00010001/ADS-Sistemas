create table cliente (
	id_cliente bigint not null auto_increment,
	nome varchar(100) not null,
	cpf varchar(20) not null,
	email varchar(100) not null,
	telefone varchar(20) not null,
	
	primary key(id_cliente)
);