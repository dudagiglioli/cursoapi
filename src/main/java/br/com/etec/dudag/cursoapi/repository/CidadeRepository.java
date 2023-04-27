package br.com.etec.dudag.cursoapi.repository;

import br.com.etec.dudag.cursoapi.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
