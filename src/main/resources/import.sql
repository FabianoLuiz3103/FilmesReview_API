
INSERT INTO tbl_genero (nome) VALUES ('Terror');
INSERT INTO tbl_genero (nome) VALUES ('Comédia');
INSERT INTO tbl_genero (nome) VALUES ('Drama');
INSERT INTO tbl_genero (nome) VALUES ('Ação');

INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('O Exorcista', 1973, 1);
INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('Halloween', 1978, 1);
INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('Sexta-Feira 13', 1980, 1);
INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('O Iluminado', 1980, 1);
INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('A Hora do Pesadelo', 1984, 1);
INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('A Bruxa', 2015, 1);
INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('Corra!', 2017, 1);
INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('Hereditário', 2018, 1);

INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('O Mentiroso', 1997, 2);
INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('Todo Mundo em Pânico', 2000, 2);
INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('As Branquelas', 2004, 2);
INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('O Virgem de 40 Anos', 2005, 2);
INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('Vizinhos', 2014, 2);

INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('Um Sonho de Liberdade', 1994, 3);
INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('Titanic', 1997, 3);
INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('Clube da Luta', 1999, 3);
INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('Cisne Negro', 2010, 3);

INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('Duro de Matar', 1988, 4);
INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('Matrix', 1999, 4);
INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('Coração Valente', 1995, 4);
INSERT INTO tbl_filme (titulo, ano, id_genero) VALUES ('Os Mercenários', 2010, 4);


INSERT INTO tbl_user (name, email, password) VALUES ('Fabiano Luiz', 'fabiano.luiz@gmail.com', 'fabianoluiz12%');
INSERT INTO tbl_user (name, email, password) VALUES ('Yolanda Binhardi', 'yolanda.binhardi@gmail.com', 'yolandabinhardi12%');
INSERT INTO tbl_user (name, email, password) VALUES ('Carlos Eduardo', 'carlos.eduardo@gmail.com', 'carloseduardo12%');
INSERT INTO tbl_user (name, email, password) VALUES ('Manoela Santos', 'manoela.santos@gmail.com', 'manoelasantos12%');

INSERT INTO tbl_review (texto, id_user, id_filme) VALUES ('Filme ótimo, bom para um fim de noite', 1, 1);
INSERT INTO tbl_review (texto, id_user, id_filme) VALUES ('Filme nojento, mas bom! ', 2, 1);
INSERT INTO tbl_review (texto, id_user, id_filme) VALUES ('Good! Good! Uau', 1, 4);