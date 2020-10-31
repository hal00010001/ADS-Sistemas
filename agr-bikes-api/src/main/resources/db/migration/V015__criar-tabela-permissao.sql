create table permissao (
	
	id_permissao bigint not null auto_increment,
	id_login bigint not null,
	id_grupo bigint not null,
				
	primary key (id_permissao)
	
);

alter table permissao add constraint fk_permissao_login
foreign key (id_login) references login (id_login);

alter table permissao add constraint fk_permissao_grupo
foreign key (id_grupo) references grupo (id_grupo);