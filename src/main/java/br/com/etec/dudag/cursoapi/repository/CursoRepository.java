package br.com.etec.dudag.cursoapi.repository;

import br.com.etec.dudag.cursoapi.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
