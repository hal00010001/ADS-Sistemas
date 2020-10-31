create table login (
	
	id_login bigint not null auto_increment,
	usuario varchar(45) not null,
	senha varchar(100) not null,
				
	primary key (id_login)
	
);