create table avaliacao (
	
	id_avaliacao bigint not null auto_increment,
	comentario varchar(400),
	nota double not null,
	data_inclusao datetime not null,
	id_cliente bigint not null,
		
	primary key (id_avaliacao)
	
);

alter table avaliacao add constraint fk_avaliacao_cliente
foreign key (id_cliente) references cliente (id_cliente)