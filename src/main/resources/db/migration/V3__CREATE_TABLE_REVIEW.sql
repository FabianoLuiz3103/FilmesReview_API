CREATE TABLE tbl_review (
        id bigint not null auto_increment,
        texto varchar(255) not null,
        id_filme bigint not null,
        id_user bigint not null,
        primary key (id)
);