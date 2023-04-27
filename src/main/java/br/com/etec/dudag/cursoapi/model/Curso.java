// campos de BD = atributos (privados) - é comum somente a minha classe
// get and set (publicos) - leem e atribuem valores - é comum a todo o meu sistema
// toda a tabela do BD gera uma classe
// hashCode so usa nos campos que ñ se repetem (chave PRIMARIA - ID)
package br.com.etec.dudag.cursoapi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "curso")

public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String nomecurso;

    @OneToMany(mappedBy = "curso")
    //gerando a relação um para muitos
    private List<Aluno> alunoscursos = new ArrayList<>();

    //getter and setter
    public Integer getId() {
        return id;
    }

    public List<Aluno> getAlunoscursos() {
        return alunoscursos;
    }

    public void setAlunoscursos(List<Aluno> alunoscursos) {
        this.alunoscursos = alunoscursos;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCurso() {
        return nomecurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomecurso = nomeCurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return id.equals(curso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
