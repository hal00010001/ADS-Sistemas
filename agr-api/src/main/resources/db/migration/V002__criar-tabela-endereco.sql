create table endereco (
	
	id_endereco bigint not null auto_increment,
	id_cliente bigint not null,
	rua varchar(100) not null,
	numero varchar(20) not null,
	bairro varchar(45) not null,
	cep varchar(15) not null,
	
	primary key (id_endereco)
	
);

alter table endereco add constraint fk_endereco_cliente
foreign key (id_cliente) references cliente (id_cliente)