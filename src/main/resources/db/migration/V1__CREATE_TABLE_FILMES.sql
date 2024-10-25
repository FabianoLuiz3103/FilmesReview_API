CREATE TABLE tbl_filme (
    id bigint not null auto_increment,
    ano integer not null,
    titulo varchar(255) not null,
    id_genero bigint not null,
    primary key (id)
);