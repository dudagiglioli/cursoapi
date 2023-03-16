Create Table Aluno(
id int not null auto_increment primary key,
nomealuno varchar (150),
idcurso int not null,
idcidade int not null
);

Alter Table Aluno add CONSTRAINT FK_Aluno_Curso foreign key(idcurso) references curso(id);

insert into Aluno(nomealuno, idcurso) values ('Maria Eduarda Giglioli', 1);
insert into Aluno(nomealuno, idcurso) values ('Juan Guilice', 4);
insert into Aluno(nomealuno, idcurso) values ('Ana Quézia Feliciano', 2);
insert into Aluno(nomealuno, idcurso) values ('Ana Paula Espindola', 3);
insert into Aluno(nomealuno, idcurso) values ('João Pedro', 5);
insert into Aluno(nomealuno, idcurso) values ('Camila Giglioli', 6);
insert into Aluno(nomealuno, idcurso)) values ('Maria Joquina', 8);


alter table Aluno add CONSTRAINT Fk_Aluno_Cidade foreign key(idcidade) references cidade(idcidade);
insert into Aluno(nomealuno, idcidade) values ('Maria', 1);
insert into Aluno(nomealuno, idcidade) values ('Juan', 5);
insert into Aluno(nomealuno, idcidade) values ('Ana Q', 3);
insert into Aluno(nomealuno, idcidade) values ('Ana P', 4);
insert into Aluno(nomealuno, idcidade) values ('João', 2);
insert into Aluno(nomealuno, idcidade) values ('Camila', 7);
insert into Aluno(nomealuno, idcidade) values ('Maria Joaquina', 6);
