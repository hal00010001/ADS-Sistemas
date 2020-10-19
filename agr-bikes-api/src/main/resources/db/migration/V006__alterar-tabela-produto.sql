ALTER TABLE produto CHANGE categoria id_categoria BIGINT;
ALTER TABLE produto ADD CONSTRAINT fk_categoria FOREIGN KEY(id_categoria) REFERENCES categoria(id_categoria);