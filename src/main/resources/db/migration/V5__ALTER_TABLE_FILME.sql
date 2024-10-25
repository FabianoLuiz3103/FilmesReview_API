ALTER TABLE tbl_filme
       add constraint genero_filme_fk
       foreign key (id_genero)
       references tbl_genero (id);
