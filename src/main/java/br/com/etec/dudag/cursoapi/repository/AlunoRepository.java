package br.com.etec.dudag.cursoapi.repository;

import br.com.etec.dudag.cursoapi.model.Aluno;
import br.com.etec.dudag.cursoapi.repository.aluno.AlunoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>, AlunoRepositoryQuery {
}
