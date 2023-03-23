Create Table Curso(
id int not null auto_increment primary key,
nomeCurso varchar(100),
);

Alter Table Aluno add CONSTRAINT FK_Aluno_Curso foreign key(idcurso) references curso(id);



