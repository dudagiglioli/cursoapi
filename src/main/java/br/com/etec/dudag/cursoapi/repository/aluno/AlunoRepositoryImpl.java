package br.com.etec.dudag.cursoapi.repository.aluno;

import br.com.etec.dudag.cursoapi.model.Aluno;
import br.com.etec.dudag.cursoapi.model.Cidade;
import br.com.etec.dudag.cursoapi.repository.filter.AlunoFilter;
import br.com.etec.dudag.cursoapi.repository.filter.CidadeFilter;
import br.com.etec.dudag.cursoapi.repository.projections.AlunoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AlunoRepositoryImpl implements AlunoRepositoryQuery{

  @PersistenceContext
  private EntityManager manager;

  @Override
  public Page<AlunoDto> Filtrar(AlunoFilter alunoFilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<AlunoDto> criteria = builder.createQuery((AlunoDto.class));
    Root<Aluno> root = criteria.from((Aluno.class));

    criteria.select(builder.construct(AlunoDto.class,
      root.get("id"),
      root.get("nomealuno"),
      root.get("cidade").get("nomecidade"),
      root.get("cidade").get("uf"),
      root.get("curso").get("nomecurso")
 ));

    Predicate[] predicates = criarRestricoes(alunoFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nomealuno")));

    TypedQuery<AlunoDto> query = manager.createQuery(criteria);
    addrestricoesdepaginacao(query, pageable);

    return new PageImpl<>(query.getResultList(),pageable, totaldePaginas(alunoFilter));
}

// ? substitui o nome da classe, deixa ela genérica
  public void totaldePaginas(TypedQuery<?> query, Pageable pageable) {
    int pagatual = pageable.getPageNumber();
    int totalderestricoesporpag = pageable.getPageSize();
    int primeiroregistropag = pagatual * totalderestricoesporpag;

    query.setFirstResult(primeiroregistropag);
    query.setMaxResults(totalderestricoesporpag);
  }
}
