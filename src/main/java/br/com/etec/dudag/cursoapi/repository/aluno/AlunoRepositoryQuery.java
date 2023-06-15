package br.com.etec.dudag.cursoapi.repository.aluno;

import br.com.etec.dudag.cursoapi.repository.filter.AlunoFilter;
import br.com.etec.dudag.cursoapi.repository.projections.AlunoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlunoRepositoryQuery {

  public Page<AlunoDto> filtrar(AlunoFilter alunoFilter, Pageable pageable);

}
