package br.com.etec.dudag.cursoapi.repository.cidade;

import br.com.etec.dudag.cursoapi.model.Cidade;
import br.com.etec.dudag.cursoapi.repository.filter.CidadeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CidadeRepositoryQuery {

    public Page<Cidade> Filtrar(CidadeFilter cidadefilter, Pageable pageable);
}
