package br.com.etec.dudag.cursoapi.repository.cidade;

import br.com.etec.dudag.cursoapi.model.Cidade;
import br.com.etec.dudag.cursoapi.repository.filter.CidadeFilter;
import org.apache.commons.lang3.StringUtils;
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
import java.util.ArrayList;
import java.util.List;

public class CidadeRepositoryImpl implements  CidadeRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Cidade> Filtrar(CidadeFilter cidadefilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Cidade> criteria = builder.createQuery((Cidade.class));
        Root<Cidade> root = criteria.from((Cidade.class));

        Predicate[] predicates = criarRestricoes(cidadefilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomecidade")));

       TypedQuery<Cidade> query = manager.createQuery(criteria);

       addrestricoesdepaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(),pageable, totaldePaginas(cidadefilter));
    }

    private Long totaldePaginas(CidadeFilter cidadefilter){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery((Long.class));
        Root<Cidade> root = criteria.from((Cidade.class));

        Predicate[] predicates = criarRestricoes(cidadefilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomecidade")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }



    private void addrestricoesdepaginacao(TypedQuery<Cidade> query, Pageable pageable){

        int pagatual = pageable.getPageNumber();
        int totalderestricoesporpag = pageable.getPageSize();
        int primeiroregistropag = pagatual * totalderestricoesporpag;

        query.setFirstResult(primeiroregistropag);
        query.setMaxResults(totalderestricoesporpag);
    }

    private Predicate[] criarRestricoes(CidadeFilter cidadefilter, CriteriaBuilder builder, Root<Cidade> root) {

        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(cidadefilter.getNomecidade())) {
            predicates.add(builder.like(builder.lower(root.get("nomecidade")),
                    "%" + cidadefilter.getNomecidade().toLowerCase() + "%"
            ));
        }

        if (!StringUtils.isEmpty(cidadefilter.getUf())) {
            predicates.add(builder.like(builder.lower(root.get("uf")),
                    "%" + cidadefilter.getUf().toLowerCase() + "%"
            ));
        }

        return predicates.toArray(new Predicate[predicates.size()]);

    }

    }
