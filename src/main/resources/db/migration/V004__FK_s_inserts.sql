Alter table aluno add constraint FK_curso_aluno
                    foreign key (idcurso) references curso(id);

Alter table aluno add constraint FK_cidade_aluno
                    foreign key (idcidade) references cidade(idcidade);

insert into curso(nomecurso) values ('Administração');

insert into cidade(nomecidade, uf) values ('Santa Cruz do Rio Pardo', 'SP');
insert into cidade(nomecidade, uf) values ('Manaus', 'AM');
insert into cidade(nomecidade, uf) values ('Maceió', 'AL');

insert into aluno(nomealuno, idcurso, idcidade) values ('Maria Eduarda', 1 , 3);
insert into aluno(nomealuno, idcurso, idcidade) values ('Juan', 1 , 3);
insert into aluno(nomealuno, idcurso, idcidade) values ('Camila', 1 , 3);