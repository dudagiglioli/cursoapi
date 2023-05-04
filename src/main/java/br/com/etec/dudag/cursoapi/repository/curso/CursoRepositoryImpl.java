package br.com.etec.dudag.cursoapi.repository.curso;

import br.com.etec.dudag.cursoapi.model.Curso;
import br.com.etec.dudag.cursoapi.repository.filter.CursoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CursoRepositoryImpl implements CursoRepositoryQuery{
    @Override
    public Page<Curso> Filtrar(CursoFilter cursoFilter, Pageable pageable) {
        return null;
    }
}
