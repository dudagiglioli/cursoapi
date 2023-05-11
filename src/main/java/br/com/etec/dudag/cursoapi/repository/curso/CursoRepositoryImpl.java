package br.com.etec.dudag.cursoapi.repository.curso;

import antlr.StringUtils;
import br.com.etec.dudag.cursoapi.model.Curso;
import br.com.etec.dudag.cursoapi.repository.filter.CursoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CursoRepositoryImpl implements CursoRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Curso> Filtrar(CursoFilter cursoFilter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder(); //criação de consulta
        CriteriaQuery<Curso> criteria = builder.createQuery(Curso.class); //select
        Root<Curso> root = criteria.from(Curso.class); // é o pai, mostra qual é  a classe pai do sql

        Predicate[] predicates = criarRestricoes(cursoFilter, builder, root);
        criteria.where(predicates);
        return null;
    }

    private Predicate[] criarRestricoes(CursoFilter cursoFilter, CriteriaBuilder builder, Root<Curso> root) {
        List<Predicate> predicates = new ArrayList<>(); // armazena os dados

        if (StringUtils)
    }
}
