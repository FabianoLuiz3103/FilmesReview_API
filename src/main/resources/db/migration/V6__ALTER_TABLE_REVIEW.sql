ALTER TABLE tbl_review
       add constraint filme_review_fk
       foreign key (id_filme)
       references tbl_filme (id);

ALTER TABLE tbl_review
       add constraint user_review_fk
       foreign key (id_user)
       references tbl_user (id);